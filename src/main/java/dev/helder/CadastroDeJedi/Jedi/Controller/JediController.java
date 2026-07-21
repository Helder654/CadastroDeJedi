package dev.helder.CadastroDeJedi.Jedi.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class JediController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }
    
    //Mock de endpoints
    //Adicionar jedi(CREATE)
    @PostMapping("/criar")
    public String criarJedi(){
        return "ninja criado";
    }

    //Mostrar todos os jedi(READ)
    @GetMapping("/todos")
    public String mostrarTodosOsJedi(){
        return "mostrar jedi";
    }

    //Mostrar jedi por id(READ)
    @GetMapping("/todosID")
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
