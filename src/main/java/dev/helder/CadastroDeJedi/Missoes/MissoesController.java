package dev.helder.CadastroDeJedi.Missoes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//LOCALHOST:8080/DELETAR
@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissao(){
        return "missao listadas com sucesso";
    }
    
    @PostMapping("/criar")
    public String criarMissao(){
        return "missão criada com sucesso";
    }
    
    @PutMapping("/alterar")
    public String editarMissao(){
        return "missão editada com sucesso";
    }

    @DeleteMapping("/delete")
    public String deletarMissao(){
        return"missao deletada";
    }
}
