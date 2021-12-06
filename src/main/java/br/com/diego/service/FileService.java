package br.com.diego.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Service
public class FileService {


    public String gerarArquivo (String conteudo) throws IOException {

        String nomeArquivo = "LogCompletoErroJob.txt";

        FileWriter arq = new FileWriter(nomeArquivo);
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf(conteudo);

        arq.close();

        log.info("Arquivo de log gerado com Sucesso!");
        return nomeArquivo;
    }

}
