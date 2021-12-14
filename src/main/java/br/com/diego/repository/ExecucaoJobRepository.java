package br.com.diego.repository;

import br.com.diego.model.Emissor;
import br.com.diego.model.ExecucaoJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class ExecucaoJobRepository {

    @Autowired
    OracleConnect oracleConnect;

    public List<ExecucaoJob> retornaJobsErros (Emissor emissor, String data, boolean isCobranca, String tipoOrigem) throws IOException {

        List<ExecucaoJob> jobs = new ArrayList<>();

        try {

            String sql = "Select * from t_execucaojob  where STATUS = 'E' and dataexecucao > to_date('"+data+"','DD/MM/YY') and dataexecucao-1 < to_date('"+data+"','DD/MM/YY')";
            Connection co = oracleConnect.conectarBanco( OracleConnect.PORTA_ORACLE, emissor.getUsuario(), emissor.getSenha(), emissor.getCaminho(),emissor.getServico());
            Statement statement = co.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            //Coleta os dados da consulta
            while (rs.next()) {
                String descricao = rs.getString("DESCRICAO");
                String nomejob = rs.getString("nomejob");
                if (!"".equals(nomejob)){
                    nomejob = nomejob.replace("com.neus.cards.business.job.","");
                }

                ExecucaoJob execucaoJob = new ExecucaoJob();
                //execucaoJob.setDataexecucao(dataexecucao);
                execucaoJob.setDescricao(descricao);
                execucaoJob.setNomejob(nomejob);
                execucaoJob.setEmissor(emissor.getNome());
                if (isCobranca){
                    if (execucaoJob.listaNomesJobsCobranca().contains(nomejob)){
                        jobs.add(execucaoJob);
                    }
                }else{
                    if (!execucaoJob.listaNomesJobsCobranca().contains(nomejob)){
                        jobs.add(execucaoJob);
                    }
                }

            }
            log.info("Quantidade registros no emissor: "+emissor.getNome()+" é: "+jobs.size());
            co.close();

        }catch(SQLException ex){ //trata os erros SQL
            log.error("Erro na consulta dos dados - "+ex.getMessage());
            return null;
        }
        return jobs;
    }

    public boolean testeComunicacao (Emissor emissor) throws IOException {

        try {

            String sql = "Select 1 from dual";
            Connection co = oracleConnect.conectarBanco( OracleConnect.PORTA_ORACLE, emissor.getUsuario(), emissor.getSenha(), emissor.getCaminho(),emissor.getServico());
            Statement statement = co.createStatement();
            statement.executeQuery(sql);

            log.info("Comunicação realizada com Sucesso!");
            co.close();
            return true;

        }catch(SQLException ex){ //trata os erros SQL
            log.error("Erro na comunicação com o banco Oracle - "+ex.getMessage());
            return false;
        }
    }

}
