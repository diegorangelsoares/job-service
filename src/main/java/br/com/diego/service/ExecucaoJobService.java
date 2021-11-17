package br.com.diego.service;

import br.com.diego.exception.DadosInvalidosException;
import br.com.diego.exception.ExecucaoJobNotFoundException;
import br.com.diego.model.ExecucaoJob;
import br.com.diego.repository.ExecucaoJobRepository;
import br.com.diego.request.DadosJobRequest;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ExecucaoJobService {

    @Autowired
    private ExecucaoJobRepository execucaoJobRepository;

    private ExecucaoJobService(ExecucaoJobRepository execucaoJobRepository){
        this.execucaoJobRepository = execucaoJobRepository;
    }

    public List<ExecucaoJob> listaJobsErros(DadosJobRequest dados){
        if (dados == null || dados.getDataInicio() == null || dados.getDataFinal() == null){
            return null;
        }

        if (dados.getDataInicio() == null || dados.getDataFinal() == null){
            return null;
        }

        Date dataIni = dados.getDataInicio();
        Date dataFim = dados.dataFinal;

        Calendar cal = Calendar.getInstance();
        cal.setTime(dataIni );
        cal.add(Calendar.DATE, -1);
        dataIni = cal.getTime();

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(dataFim );
        cal2.add(Calendar.DATE, 1);
        dataFim = cal2.getTime();

        if (dados.getStatusExecucao() == null){
            return execucaoJobRepository.findByDataExecucao(dataIni, dataFim)
//                .orElseThrow(() -> new ExecucaoJobNotFoundException(String.format(
//                        "Não foi encontrado nenhum job com os dados informados!", "")))
                    ;
        }else{
            return execucaoJobRepository.findByDataExecucaoAndStatus(dataIni, dataFim, dados.getStatusExecucao())
//                .orElseThrow(() -> new ExecucaoJobNotFoundException(String.format(
//                        "Não foi encontrado nenhum job com os dados informados!", "")))
                    ;
        }


    }

}
