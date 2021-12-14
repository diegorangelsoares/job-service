package br.com.diego.service;

import br.com.diego.model.Emissor;
import br.com.diego.model.ExecucaoJob;
import br.com.diego.repository.ExecucaoJobRepository;
import br.com.diego.repository.OracleConnect;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Service
public class ExecucaoJobService {

    @Autowired
    EmissorService emissorService;

    @Autowired
    MailService mailService;

    @Autowired
    HistoricoMonitoriaService historicoMonitoriaService;

    @Autowired
    ExecucaoJobRepository execucaoJobRepository;

    public List<ExecucaoJob> retornaJobsErros (String data, boolean isCobranca, String tipoOrigem) throws IOException {

        List<Emissor> emissores = emissorService.retornaEmissores();

        List<ExecucaoJob> jobs = new ArrayList<>();

        if (emissores != null && !emissores.isEmpty()){

            log.info("Existem emissores cadastrados. Quantidade: "+emissores.size());
            log.info("Início da monitoria... ");

            for (Emissor e: emissores){

                jobs.addAll(execucaoJobRepository.retornaJobsErros(e, data, isCobranca, tipoOrigem));

            }

            log.info("Fim da monitoria... ");

        }else{
            log.info("Não existe emissores cadastrados!!!");
        }
        String assunto = "";
        if (jobs!=null && !jobs.isEmpty()){
            if (isCobranca){
                assunto = "<<ALERTA DE ERRO EM JOBS DE COBRANÇA>> - Data: "+data;
            }else{
                assunto = "<<ALERTA DE ERRO EM JOBS>> - Data: "+data;
            }
            mailService.sendMail(assunto, data,
                    "Segue relação de jobs com erro: \n\n"+corpoEmail(jobs), GerarTextoDoArquivo(jobs), isCobranca);
        }else{
            if (isCobranca){
                assunto = "<<ALERTA JOBS DE COBRANÇA>> SEM ERROS NA DATA: "+data;
            }else{
                assunto = "<<ALERTA JOBS>> SEM ERROS NA DATA: "+data;
            }
            mailService.sendMail(assunto, data,
                    "Não houve erro nos jobs na data: "+data, "", isCobranca);
        }
        return jobs;

    }

    public String corpoEmail(List<ExecucaoJob> jobs){
        String corpo = "Opa,\n\n" +
                "Tivemos alguns erros de Jobs nos emissores abaixo:\n\n";
        for (ExecucaoJob job: jobs){
            corpo = corpo + "Emissor: "+job.getEmissor()+" - NomeJob: "+job.getNomejob()+"\n";
        }
        return corpo;
    }

    public String GerarTextoDoArquivo(List<ExecucaoJob> jobs){
        String corpo = "";
        for (ExecucaoJob job: jobs){
            corpo = corpo + "Erro de job do emissor: "+job.getEmissor()+"\n"+ job.toString() + "\n\n";
        }
        return corpo;
    }



}
