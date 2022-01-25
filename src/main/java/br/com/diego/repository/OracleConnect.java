package br.com.diego.repository;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.stereotype.Service;

import java.sql.*;

@Slf4j
@Service
public class OracleConnect {

    public static String PORTA_ORACLE = "1521";

    public Connection conectarBanco (String porta, String usuario, String senha, String caminho, String servico){
        OracleDataSource ods;
        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@"+caminho+":"+porta+":"+servico);
            ods.setUser(usuario); // [nome do usuário]
            ods.setPassword(senha); // [senha]
            Connection con = ods.getConnection();
            log.info("Conexão aberta com "+servico+"!");
            return con;
        } catch (SQLException ex) {
            log.error("Falha na conexão com "+servico+" no caminho "+caminho+" do usuario "+usuario+" - "+ex.getMessage());
            return null;
        }

    }

}
