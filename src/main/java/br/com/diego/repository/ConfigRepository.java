package br.com.diego.repository;

import br.com.diego.model.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {

    List<Config> findAllByName(String name);

}
