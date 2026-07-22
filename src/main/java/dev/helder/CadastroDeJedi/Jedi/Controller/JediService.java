package dev.helder.CadastroDeJedi.Jedi.Controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class JediService {

    
    private JediRepository jediRepository;

    public JediService(JediRepository jediRepository) {
        this.jediRepository = jediRepository;
    }

    //listar todos meus jedi
    public List<JediModel> listarJedi(){
        return jediRepository.findAll();
    }

    //listar jedi em ordem de id
    public List<JediModel> listarJediPorId() {
    return jediRepository.findAll(Sort.by("id"));
}
    
}
