package dev.helder.CadastroDeJedi.Jedi.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<JediDTO> listarJedi(){
        List<JediModel> jedi = jediRepository.findAll();
        return jedi.stream()
        .map(jediMapper::map)
        .collect(Collectors.toList());
        }

    //listar jedi em ordem de id
    public JediDTO listarJediPorId(Long id) {
    Optional<JediModel> jediPorId = jediRepository.findById(id);
    return jediPorId.map(jediMapper::map).orElse(null);
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
    public JediDTO atualizarJedi(Long id, JediDTO jediDTO){
        Optional<JediModel> jediExistente = jediRepository.findById(id);
        if(jediExistente.isPresent()){
            JediModel jediAtulizado = jediMapper.map(jediDTO);
            jediAtulizado.setId(id);
            JediModel jediSalvo = jediRepository.save(jediAtulizado);
            return jediMapper.map(jediSalvo);
        }
        return null;
    }
}
