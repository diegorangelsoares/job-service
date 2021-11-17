package br.com.diego.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DadosJobRequest {

    public Date dataInicio;
    public Date dataFinal;
    public String statusExecucao;
}
