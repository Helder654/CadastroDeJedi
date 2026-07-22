package dev.helder.CadastroDeJedi.Missoes;

import java.util.List;

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

    // criar uma nova missao
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

}
