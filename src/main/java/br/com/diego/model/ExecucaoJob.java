package br.com.diego.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="t_execucaojob")
public class ExecucaoJob {

    @Id
    private Integer idexecucaojob;
    //@Column(unique = true)
    private Date dataexecucao;
    private String descricao;
    private String status;

    private String nomejob;
    private String version;

}
