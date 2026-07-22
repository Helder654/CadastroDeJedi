package dev.helder.CadastroDeJedi.Jedi.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jedi")
public class JediController {

    private JediService jediService;

    public JediController(JediService jediService) {
        this.jediService = jediService;
    }

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
    public List<JediModel> mostrarTodosOsJedi(){
        return jediService.listarJedi();
    }

    //Mostrar jedi por id(READ)
    @GetMapping("/listar/{id}")
    public JediModel mostrarOsJediPorId(@PathVariable Long id){
        return jediService.listarJediPorId(id);
    }
    //Alterar dados do jedi(UPDATE)
    @PutMapping("/alterarID")
    public String alterarJediPorId(){
        return"jedi alterado";
    }

    //Deletar jedi(DELETE)
    @DeleteMapping("/deleteID")
    public String deletarJediPorId(){
        return"jedi deletado por id";
    }
}
