package br.com.diego.scheduler;

import br.com.diego.model.HistoricoMonitoria;
import br.com.diego.service.ExecucaoJobService;
import br.com.diego.service.HistoricoMonitoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
@Slf4j
public class AgendadorMonitoria {

    private static boolean CONTINUA_VERIFICANDO = true;

    private static boolean VERIFICAO_INICIADA = false;

    @Autowired
    HistoricoMonitoriaService historicoMonitoriaService;

    @Autowired
    ExecucaoJobService execucaoJobService;

    //1000 é 1segundo
    @Scheduled(fixedDelay = 30000)
    public void verificaPorHora() {
        log.info("Verificando scheduler...");
        if (AgendadorMonitoria.CONTINUA_VERIFICANDO = true){
            List<HistoricoMonitoria> historicos = new ArrayList<>();
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yy");
            String dataString = out.format(new Date());
            historicos = historicoMonitoriaService.buscarMonitorias(dataString, "A");
            if (historicos != null && !historicos.isEmpty()){
                CONTINUA_VERIFICANDO = false;
            }else{
                //executar a monitoria
                execucaoJobService.retornaJobsErros(dataString, false, HistoricoMonitoria.MONITORIA_AUTOMATICA);
                CONTINUA_VERIFICANDO = false;
            }
        }
    }

}
