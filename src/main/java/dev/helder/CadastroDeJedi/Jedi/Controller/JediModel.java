package dev.helder.CadastroDeJedi.Jedi.Controller;

import java.util.List;

import dev.helder.CadastroDeJedi.Missoes.MissoesModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//Entity transforma a classe em uma entidade para o banco de dados
//JPA = Java Persistant API
@Entity
@Table(name = "tb_cadastro")

public class JediModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;
    
    private String nome;
    
    private int idade;
    
    private String email;
    
    //@ManyToOne um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //foreing key
    private MissoesModel missoes;

    public JediModel() {
    }

    public JediModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }

    public void setIdade(int idade) { this.idade = idade; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }    
}


    
    