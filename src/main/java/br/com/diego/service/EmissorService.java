package br.com.diego.service;

import br.com.diego.model.Emissor;
import br.com.diego.repository.EmissorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmissorService {

    @Autowired
    EmissorRepository emissorRepository;

    public List<Emissor> retornaEmissores (){
        return emissorRepository.findAllByMonitorar("S");
    }


}
