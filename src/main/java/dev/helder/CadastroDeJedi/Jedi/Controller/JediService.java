package dev.helder.CadastroDeJedi.Jedi.Controller;

import java.util.List;
import java.util.Optional;


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
    public JediModel listarJediPorId(long id) {
    Optional<JediModel> jediPorId = jediRepository.findById(id);
    return jediPorId.orElse(null);
}
    
}
