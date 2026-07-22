package dev.helder.CadastroDeJedi.Missoes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.helder.CadastroDeJedi.Jedi.Controller.JediModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private long id;
    
    @Column(name = "nome_missao")
    private String nome;
    
    @Column(unique = true)
    private char dificuldade;
    
    //@OneToMany uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<JediModel> jedi;
}
    
    