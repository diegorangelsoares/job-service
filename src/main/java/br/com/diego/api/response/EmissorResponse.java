package br.com.diego.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmissorResponse {

    private String nome;
    private String monitorar;

    public EmissorResponse(){
    }

    public EmissorResponse(String nome, String monitorar){
        this.nome = nome;
        this.monitorar = monitorar;
    }

    public String toString(EmissorResponse emissorResponse){
        return
                "Nome: "+emissorResponse.getNome()+"\n" +
                "Monitorar: "+emissorResponse.getMonitorar()+"\n"
                ;
    }

}
