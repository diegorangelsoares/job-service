package br.com.diego.controller;

import br.com.diego.model.ExecucaoJob;
import br.com.diego.request.DadosJobRequest;
import br.com.diego.service.ExecucaoJobService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Service endpoint")
@RequestMapping("job-service")
@Slf4j
public class ExecucaoJobController {

    @Autowired
    private ExecucaoJobService execucaoJobService;

    @GetMapping(value = "/")
    public ResponseEntity<List<ExecucaoJob>> findTest(
            @Validated @RequestBody DadosJobRequest dados) throws Exception {
        log.info("Buscando erros de jobs com a data: "+dados);
        var execucaoJobs = execucaoJobService.listaJobsErros(dados);

        if (dados.getDataInicio() == null || dados.getDataFinal() == null)
            throw new RuntimeException("Dados da request inválidos.");

        if (execucaoJobs == null)
            throw new RuntimeException("ExecucaoJob not found.");

        return ResponseEntity.status(HttpStatus.OK).body(execucaoJobs);
    }

}
