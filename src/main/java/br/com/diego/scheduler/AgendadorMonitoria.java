package br.com.diego.scheduler;

import br.com.diego.model.HistoricoMonitoria;
import br.com.diego.service.ExecucaoJobService;
import br.com.diego.service.HistoricoMonitoriaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
@Slf4j
public class AgendadorMonitoria {

    public static boolean CONTINUA_VERIFICANDO = true;

    public static boolean VERIFICAO_INICIADA = false;

    @Autowired
    HistoricoMonitoriaService historicoMonitoriaService;

    @Autowired
    ExecucaoJobService execucaoJobService;

    //1000 é 1segundo
    @Scheduled(fixedDelay = 30000)
    public void verificaPorHora() throws IOException {
        log.info("Scheduler em execução...");

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
                        execucaoJobService.retornaJobsErros(dataString, false, HistoricoMonitoria.MONITORIA_AUTOMATICA);
                        execucaoJobService.retornaJobsErros(dataString, true, HistoricoMonitoria.MONITORIA_AUTOMATICA);
                        historicoMonitoriaService.salvar(HistoricoMonitoria.MONITORIA_AUTOMATICA);
                        CONTINUA_VERIFICANDO = false;
                    }
                }
            }
        }
    }

}
