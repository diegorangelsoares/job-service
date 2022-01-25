package br.com.diego.scheduler;

import br.com.diego.api.response.EmissorResponse;
import br.com.diego.model.HistoricoMonitoria;
import br.com.diego.service.ExecucaoJobService;
import br.com.diego.service.HistoricoMonitoriaService;
import br.com.diego.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Component
@EnableScheduling
@Slf4j
public class AgendadorMonitoria {

    public static boolean CONTINUA_VERIFICANDO = true;

    public static boolean VERIFICAO_INICIADA = false;

    public static long QUANTIDADE_VERIFICACAO = 0;

    public static List<String> EMISSORES_COM_ERRO = new ArrayList<>();

    @Autowired
    HistoricoMonitoriaService historicoMonitoriaService;

    @Autowired
    ExecucaoJobService execucaoJobService;

    @Autowired
    MailService mailService;

    //1000 é 1segundo
    @Scheduled(fixedDelay = 30000)
    public void verificaPorHora() throws IOException {
        log.info("Scheduler em execução...");
        //log.info("Quantidade de verificações: "+AgendadorMonitoria.QUANTIDADE_VERIFICACAO);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
        int hora = Integer.parseInt(dtf.format(LocalDateTime.now()));

        //Iniciar verificações apenas após as 6 horas da manhã
        if (hora > 5) {
            if (AgendadorMonitoria.CONTINUA_VERIFICANDO == true) {

                List<HistoricoMonitoria> historicos = new ArrayList<>();
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yy");
                String dataString = out.format(new Date());
                historicos = historicoMonitoriaService.buscarMonitorias(dataString, "A");
                if (historicos != null && !historicos.isEmpty()) {
                    CONTINUA_VERIFICANDO = false;
                } else {
                    //executar a monitoria
                    if (execucaoJobService.testeComunicacaoDB()) {

                        Calendar data = new GregorianCalendar();
                        //Verificar se é segunda-feita para monitorar o retroativo sábido e domingo
                        if ((data.get(Calendar.DAY_OF_WEEK) == 2)){

                            log.info("Segunda, precisa verificar o sábado e o domingo...");

                            //Monitorar o sábado
                            Date dataMonitorar = DateUtils.addDays(new Date(),-2);
                            dataString = out.format(dataMonitorar);
                            log.info("Monitorando a data: "+dataString);
                            execucaoJobService.retornaJobsErros(dataString, false, HistoricoMonitoria.MONITORIA_AUTOMATICA);
                            execucaoJobService.retornaJobsErros(dataString, true, HistoricoMonitoria.MONITORIA_AUTOMATICA);

                            //Monitorar o domingo
                            dataMonitorar = DateUtils.addDays(new Date(),-1);
                            dataString = out.format(dataMonitorar);
                            log.info("Monitorando a data: "+dataString);
                            execucaoJobService.retornaJobsErros(dataString, false, HistoricoMonitoria.MONITORIA_AUTOMATICA);
                            execucaoJobService.retornaJobsErros(dataString, true, HistoricoMonitoria.MONITORIA_AUTOMATICA);

                            //Monitorar o dia da segunda
                            dataString = out.format(new Date());
                            log.info("Monitorando a data: "+dataString);
                            execucaoJobService.retornaJobsErros(dataString, false, HistoricoMonitoria.MONITORIA_AUTOMATICA);
                            execucaoJobService.retornaJobsErros(dataString, true, HistoricoMonitoria.MONITORIA_AUTOMATICA);

                            historicoMonitoriaService.salvar(HistoricoMonitoria.MONITORIA_AUTOMATICA);
                            CONTINUA_VERIFICANDO = false;
                        } else {
                            //System.out.println("É os demais dias...");
                            execucaoJobService.retornaJobsErros(dataString, false, HistoricoMonitoria.MONITORIA_AUTOMATICA);
                            execucaoJobService.retornaJobsErros(dataString, true, HistoricoMonitoria.MONITORIA_AUTOMATICA);
                            historicoMonitoriaService.salvar(HistoricoMonitoria.MONITORIA_AUTOMATICA);
                            CONTINUA_VERIFICANDO = false;
                        }

                    }
                }
            }
        }

        if (EMISSORES_COM_ERRO != null && !EMISSORES_COM_ERRO.isEmpty()){
            String assunto = "<<EMISSORES QUE NÃO FORAM POSSÍVEIS DE MONITORAR - API-MONITORIA-JOB>>";
            String corpoEmail = "";
            AgendadorMonitoria.EMISSORES_COM_ERRO = AgendadorMonitoria.EMISSORES_COM_ERRO.stream().distinct().collect(Collectors.toList());
            for (String e: EMISSORES_COM_ERRO){
                corpoEmail = corpoEmail + e + "\n";
            }
            mailService.sendMail(assunto, "",
                    "Segue relação de emissores que nao foi possivel monitorar os jobs: \n\n"+corpoEmail, "", true);

            //Enviar email com emissores que deram problema na consulta e zerar a lista
            EMISSORES_COM_ERRO = new ArrayList<>();
        }
    }

}
