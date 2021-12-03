package br.com.diego.service;

import br.com.diego.model.HistoricoMonitoria;
import br.com.diego.repository.HistoricoMonitoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.MonitorInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class HistoricoMonitoriaService{

    @Autowired
    HistoricoMonitoriaRepository historicoMonitoriaRepository;

    public void salvar(String tipoOrigem){
        HistoricoMonitoria historicoMonitoria = new HistoricoMonitoria();
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yy");
        String dataString = out.format(new Date());
        historicoMonitoria.setDataMonitoria(dataString);
        historicoMonitoria.setOrigemMonitoria(tipoOrigem);
        historicoMonitoriaRepository.save(historicoMonitoria);
    }

    public List<HistoricoMonitoria> buscarMonitorias(String data, String tipoOrigem){
        return historicoMonitoriaRepository.findAllByAndOrigemMonitoriaAndAndDataMonitoria(tipoOrigem, data);
    }

}
