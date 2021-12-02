package br.com.diego.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity (name = "t_historicomonitoria")
public class HistoricoMonitoria implements Serializable {

    public static String MONITORIA_AUTOMATICA = "A";
    public static String MONITORIA_MANUAL = "M";

    private static final long serialVersionUID = 9193243194135209166L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String dataMonitoria;

    //Automatica ou Manual   A  ou  M
    private String origemMonitoria;



}
