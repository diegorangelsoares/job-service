package br.com.diego.api.controller;

import br.com.diego.api.response.EmissorResponse;
import br.com.diego.service.EmissorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Emissores")
@RequestMapping("job-service")
@Slf4j
public class EmissorController {

    @Autowired
    EmissorService emissorService;

    @GetMapping(value = "/GetEmissoresCadastrados/")
    public ResponseEntity<?> GetEmissoresCadastrados() throws Exception {

        log.info("Buscando emissores cadastrados...");

        List<EmissorResponse> emissores = emissorService.retornaEmissoresCadastrados();

        return ResponseEntity.status(HttpStatus.OK).body(emissores);
    }

}
