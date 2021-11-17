package br.com.diego.repository;

import br.com.diego.model.ExecucaoJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExecucaoJobRepository extends JpaRepository<ExecucaoJob, Long> {

    @Query("SELECT u FROM t_execucaojob u WHERE u.dataexecucao > ?1 and u.dataexecucao < ?2")
    List<ExecucaoJob> findByDataExecucao(@Temporal Date inicio, @Temporal Date fim);

    @Query("SELECT u FROM t_execucaojob u WHERE u.dataexecucao > ?1 and u.dataexecucao < ?2 and u.status = ?3")
    List<ExecucaoJob> findByDataExecucaoAndStatus(@Temporal Date inicio, @Temporal Date fim, String status);

    @Query("SELECT u FROM t_execucaojob u WHERE u.dataexecucao = '16/11/21'")
    List<ExecucaoJob> findUserByTest();

}
