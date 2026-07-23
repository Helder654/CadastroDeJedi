package dev.helder.CadastroDeJedi.Jedi.Controller;

import org.springframework.stereotype.Component;

@Component
public class JediMapper {

    public JediModel map(JediDTO jediDTO){
        JediModel jediModel = new JediModel();
        
        jediModel.setId(jediDTO.getId());
        jediModel.setNome(jediDTO.getNome());
        jediModel.setEmail(jediDTO.getEmail());
        jediModel.setIdade(jediDTO.getIdade());
        jediModel.setMissoes(jediDTO.getMissoes());
        jediModel.setRank(jediDTO.getRank());

        return jediModel;
    }

    public JediDTO map(JediModel jediModel){
        JediDTO jediDTO = new JediDTO();
        
        jediDTO.setEmail(jediModel.getEmail());
        jediDTO.setId(jediModel.getId());
        jediDTO.setIdade(jediModel.getIdade());
        jediDTO.setMissoes(jediModel.getMissoes());
        jediDTO.setNome(jediModel.getNome());
        jediDTO.setRank(jediModel.getRank());

        return jediDTO;






    }
}
