package dev.helder.CadastroDeJedi.Missoes;

import java.util.List;

import dev.helder.CadastroDeJedi.Jedi.Controller.JediModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nome;
    
    private char dificuldade;
    
    //@OneToMany uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<JediModel> jedi;
}
    
    