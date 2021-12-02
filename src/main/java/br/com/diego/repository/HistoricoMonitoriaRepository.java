package br.com.diego.repository;

import br.com.diego.model.HistoricoMonitoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoricoMonitoriaRepository extends JpaRepository<HistoricoMonitoria, Long> {

    List<HistoricoMonitoria> findAllByAndOrigemMonitoriaAndAndDataMonitoria(String tipoOrigem, String data);
}
