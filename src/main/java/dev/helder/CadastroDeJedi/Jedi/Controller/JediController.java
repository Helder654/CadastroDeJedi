package dev.helder.CadastroDeJedi.Jedi.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jedi")
public class JediController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }
    
    //Mock de endpoints
    //Adicionar jedi(CREATE)
    @PostMapping("/criar")
    public String criarJedi(){
        return "ninja criado com sucesso";
    }

    //Mostrar todos os jedi(READ)
    @GetMapping("/listar")
    public String mostrarTodosOsJedi(){
        return "jedi listados com sucesso";
    }

    //Mostrar jedi por id(READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsJediPorId(){
        return "mostrar jedi por id";
    }
    //Alterar dados do jedi(UPDATE)
    @PutMapping("alterarID")
    public String alterarJediPorId(){
        return"jedi alterado";
    }

    //Deletar jedi(DELETE)
    @DeleteMapping("/deleteID")
    public String deletarJediPorId(){
        return"jedi deletado por id";
    }
}
