package br.com.diego.api.controller;

import br.com.diego.model.ExecucaoJob;
import br.com.diego.model.HistoricoMonitoria;
import br.com.diego.scheduler.AgendadorMonitoria;
import br.com.diego.service.ExecucaoJobService;
import br.com.diego.service.HistoricoMonitoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Tag(name = "Jobs")
@RequestMapping("job-service")
@Slf4j
public class ExecucaoJobController {

    @Autowired
    ExecucaoJobService execucaoJobService;

    @Autowired
    HistoricoMonitoriaService historicoMonitoriaService;

    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yy");

    @GetMapping(value = "/findJobsToDate/")
    public ResponseEntity<?> findJobsToDate(@RequestParam String data) throws Exception {

        log.info("Buscando erros de jobs com a data: "+data);

        List<ExecucaoJob> jobs = execucaoJobService.retornaJobsErros(data, false, HistoricoMonitoria.MONITORIA_MANUAL);

        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    @GetMapping(value = "/findJobsToday/")
    public ResponseEntity<?> findJobsToday() throws Exception {

        String result = out.format(new Date());

        log.info("Buscando erros de jobs com a data: "+result);

        List<ExecucaoJob> jobs = execucaoJobService.retornaJobsErros(result, false, HistoricoMonitoria.MONITORIA_MANUAL);

        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    @GetMapping(value = "/findJobsToDateCobranca/")
    public ResponseEntity<?> findJobsToDateCobranca(@RequestParam String data) throws Exception {
        log.info("Buscando erros de jobs com a data: "+data);
        List<ExecucaoJob> jobs = execucaoJobService.retornaJobsErros(data, true, HistoricoMonitoria.MONITORIA_MANUAL);

        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    @GetMapping(value = "/findJobsTodayCobranca/")
    public ResponseEntity<?> findJobsTodayCobranca() throws Exception {

        String result = out.format(new Date());

        log.info("Buscando erros de jobs com a data: "+result);

        List<ExecucaoJob> jobs = execucaoJobService.retornaJobsErros(result, true, HistoricoMonitoria.MONITORIA_MANUAL);

        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    @PostMapping(value = "/ForcarNewAutomatic/")
    public ResponseEntity<?> ForcarNewAutomatic() throws Exception {

        String result = out.format(new Date());

        log.info("Resetando busca automatica na data: "+result);

        historicoMonitoriaService.removeHistoricoPorData(result);

        AgendadorMonitoria.CONTINUA_VERIFICANDO = true;

        return ResponseEntity.status(HttpStatus.OK).body("Verificação será iniciada novamente!");
    }



}
