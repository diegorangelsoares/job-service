package br.com.diego.service;

import br.com.diego.model.Config;
import br.com.diego.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {

    @Autowired
    ConfigRepository configRepository;

    public String returnValue(String name){
        List<Config> configs = configRepository.findAllByName(name);
        if (configs != null && !configs.isEmpty()){
            Config config = configs.get(0);
            return config.getValue();
        }else{
            return "";
        }

    }


}
