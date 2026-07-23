package dev.helder.CadastroDeJedi.Jedi.Controller;

import dev.helder.CadastroDeJedi.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class JediDTO {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private MissoesModel missoes;
    private String rank;
}
