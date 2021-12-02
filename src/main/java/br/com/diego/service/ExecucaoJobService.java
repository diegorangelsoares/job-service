package br.com.diego.service;

import br.com.diego.model.Emissor;
import br.com.diego.model.ExecucaoJob;
import br.com.diego.repository.OracleConnect;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Service
public class ExecucaoJobService {

    @Autowired
    OracleConnect oracleConnect;

    @Autowired
    EmissorService emissorService;

    @Autowired
    MailService mailService;

    @Autowired
    HistoricoMonitoriaService historicoMonitoriaService;

    public List<ExecucaoJob> retornaJobsErros (String data, boolean isCobranca, String tipoOrigem){

        List<Emissor> emissores = emissorService.retornaEmissores();

        List<ExecucaoJob> jobs = new ArrayList<>();

        if (emissores != null && !emissores.isEmpty()){
            log.info("Tem emissores quantidade: "+emissores.size());

            for (Emissor e: emissores){
                OracleConnect oracleConnect = new OracleConnect();

                try {

                    String sql = "Select * from t_execucaojob  where STATUS = 'E' and dataexecucao > to_date('"+data+"','DD/MM/YY') and dataexecucao-1 < to_date('"+data+"','DD/MM/YY')";
                    //log.info("SQL: "+sql);
                    Connection co = oracleConnect.conectarBanco( OracleConnect.PORTA_ORACLE, e.getUsuario(), e.getSenha(), e.getCaminho(),e.getServico());
                    Statement statement = co.createStatement();
                    ResultSet rs = statement.executeQuery(sql);

                    //Imprime o resultado na tabela
                    while (rs.next()) {
                        String idexecucaojob = rs.getString("idexecucaojob");
                        String dataexecucao = rs.getString("dataexecucao");
                        String descricao = rs.getString("DESCRICAO");
                        String status = rs.getString("status");
                        String nomejob = rs.getString("nomejob");

                        ExecucaoJob execucaoJob = new ExecucaoJob();
                        //execucaoJob.setDataexecucao(dataexecucao);
                        execucaoJob.setDescricao(descricao);
                        execucaoJob.setEmissor(e.getNome());
                        if (isCobranca){
                            if (execucaoJob.listaNomesJobsCobranca().contains(descricao)){
                                jobs.add(execucaoJob);
                            }
                        }else{
                            jobs.add(execucaoJob);
                        }

                    }
                    log.info("Quantidade registros no emissor: "+e.getNome()+" é: "+jobs.size());
                    co.close();

                }catch(SQLException ex){ //trata os erros SQL
                    log.error("Erro na consulta dos dados - "+ex.getMessage());
                    return null;
                }
            }

        }else{
            log.info("Não existe emissores cadastrados!!!");
        }
        if (jobs!=null && !jobs.isEmpty()){
            mailService.enviar("TESTE", data,
                    "Segue relação de jobs com erro: \n\n"+corpoEmail(jobs));
        }
        historicoMonitoriaService.salvar(tipoOrigem);
        return jobs;

    }

    public String corpoEmail(List<ExecucaoJob> jobs){
        String corpo = "";
        for (ExecucaoJob job: jobs){
            corpo = corpo + "Erro de job do emissor: "+job.getEmissor()+"\n"+ job.toString() + "\n\n";
        }
        return corpo;
    }



}
