package br.com.diego.repository;

import br.com.diego.model.Emissor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmissorRepository extends JpaRepository<Emissor, Long> {

    //List<Emissor> findByMonitorar(String Monitorar);

//    @Query (value = "")
//    List<Emissor> findByMonitorar(String Monitorar);

    List<Emissor> findAllByMonitorar(String Monitorar);

}
