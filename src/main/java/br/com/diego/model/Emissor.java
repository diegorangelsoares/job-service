package br.com.diego.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="t_emissor")
public class Emissor {

    @Id
    private Integer id;
    //@Column(unique = true)
    private String nome;
    private String usuario;
    private String senha;

    private String caminho;
    private String servico;

    private String monitorar;

}
