package br.com.diego.repository;

import br.com.diego.model.Emissor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmissorRepository extends JpaRepository<Emissor, Long> {

    List<Emissor> findAllByMonitorar(String Monitorar);

}
