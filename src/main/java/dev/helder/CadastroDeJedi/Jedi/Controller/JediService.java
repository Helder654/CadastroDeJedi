package dev.helder.CadastroDeJedi.Jedi.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

@Service
public class JediService {

    private JediRepository jediRepository;
    private JediMapper jediMapper;

    public JediService(JediRepository jediRepository, JediMapper jediMapper) {
        this.jediRepository = jediRepository;
        this.jediMapper = jediMapper;
    }

    //listar todos meus jedi
    public List<JediModel> listarJedi(){
        return jediRepository.findAll();
    }

    //listar jedi em ordem de id
    public JediModel listarJediPorId(Long id) {
    Optional<JediModel> jediPorId = jediRepository.findById(id);
    return jediPorId.orElse(null);
}
    //criar um novo jedi
    public JediDTO criarJedi(JediDTO jediDTO){
        JediModel jedi = jediMapper.map(jediDTO);
        jedi = jediRepository.save(jedi);
        return jediMapper.map(jedi);
    }

    //deletar um jedi por id - tem que ser um metodo void
    public void deletarJediPorId(Long id){
        jediRepository.deleteById(id);
    }

    //atualizar jedi
    public JediModel atualizarJedi(Long id, JediModel jediAtualizado){
        if(jediRepository.existsById(id)){
            jediAtualizado.setId(id);
            return jediRepository.save(jediAtualizado);
        }
        return null;
    }
}
