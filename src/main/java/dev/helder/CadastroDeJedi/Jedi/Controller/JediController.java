package dev.helder.CadastroDeJedi.Jedi.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jedi")
public class JediController {

    private final JediService jediService;

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
    public ResponseEntity<String> criarJedi(@RequestBody JediDTO jedi){
        JediDTO novoJedi = jediService.criarJedi(jedi);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Jedi criado com sucesso: " + novoJedi.getNome() + " (ID): " + novoJedi.getId());
    }

    //Mostrar todos os jedi(READ)
    @GetMapping("/listar")
    public ResponseEntity<List<JediDTO>> mostrarTodosOsJedi(){
        List<JediDTO> jediLista = jediService.listarJedi();   
        return ResponseEntity.ok(jediLista);
    }

    //Mostrar jedi por id(READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarOsJediPorId(@PathVariable Long id){

        JediDTO jedi = jediService.listarJediPorId(id);

        if(jedi != null){
            return ResponseEntity.ok(jedi);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("O Jedi com Id " + id + " Não encontrado");
        }
    }

    //Alterar dados do jedi(UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarJediPorId(@PathVariable Long id, @RequestBody JediDTO jediAtualizado){
        
        JediDTO jedi = jediService.atualizarJedi(id, jediAtualizado);

        if(jedi != null){
            return ResponseEntity.ok(jedi);
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Id de Jedi não encontrado");
        }
    }

    //Deletar jedi(DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarJedi(@PathVariable Long id){
        if(jediService.listarJediPorId(id) != null){
            jediService.deletarJediPorId(id);
            return ResponseEntity.ok("Jedi do Id: " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O Jedi com Id " + id + " Não encontrado");
        }
    }
}
