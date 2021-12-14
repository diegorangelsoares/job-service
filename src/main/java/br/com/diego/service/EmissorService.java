package br.com.diego.service;

import br.com.diego.api.response.EmissorResponse;
import br.com.diego.model.Emissor;
import br.com.diego.repository.EmissorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<EmissorResponse> retornaEmissoresCadastrados (){
        List<Emissor> emissors = emissorRepository.findAll();
        List<EmissorResponse> emissorResponses = new ArrayList<>();
        for (Emissor e: emissors){
            EmissorResponse em = new EmissorResponse();
            em.setNome(e.getNome());
            em.setMonitorar(e.getMonitorar());
            emissorResponses.add(em);
        }
        return emissorResponses;
    }


}
