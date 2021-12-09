package br.com.diego.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="t_config")
public class Config implements Serializable {

    public static String CONFIG_NAME_EMAIL_CORE = "EMAIL_CORE";
    public static String CONFIG_NAME_EMAIL_COBRANCA = "EMAIL_COBRANCA";

    public static String CONFIG_EMAIL_DEFAULT = "diegorangeljpa@gmail.com";

    private static final long serialVersionUID = 9193243194135209166L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String value;

}
