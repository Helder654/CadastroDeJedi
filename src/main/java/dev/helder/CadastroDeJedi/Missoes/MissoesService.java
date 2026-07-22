package dev.helder.CadastroDeJedi.Missoes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //Listar missão por id
    public MissoesModel listarMissoesPorId(Long id) {
    Optional<MissoesModel> MissaoPorId = missoesRepository.findById(id);
    return MissaoPorId.orElse(null);
    }

    //Criar uma nova missao
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Deletar uma missao pelo id
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

}
