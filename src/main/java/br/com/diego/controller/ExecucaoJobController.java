package br.com.diego.controller;

import br.com.diego.model.ExecucaoJob;
import br.com.diego.model.HistoricoMonitoria;
import br.com.diego.request.DadosJobRequest;
import br.com.diego.service.ExecucaoJobService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Tag(name = "Service endpoint")
@RequestMapping("job-service")
@Slf4j
public class ExecucaoJobController {

    @Autowired
    ExecucaoJobService execucaoJobService;

    @GetMapping(value = "/findJobsToDate/")
    public ResponseEntity<?> findJobsToDate(@RequestParam String data) throws Exception {

        log.info("Buscando erros de jobs com a data: "+data);

        List<ExecucaoJob> jobs = execucaoJobService.retornaJobsErros(data, false, HistoricoMonitoria.MONITORIA_MANUAL);

        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    @GetMapping(value = "/findJobsToday/")
    public ResponseEntity<?> findJobsToday() throws Exception {

        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yy");

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


        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yy");

        String result = out.format(new Date());

        log.info("Buscando erros de jobs com a data: "+result);

        List<ExecucaoJob> jobs = execucaoJobService.retornaJobsErros(result, true, HistoricoMonitoria.MONITORIA_MANUAL);

        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

}
