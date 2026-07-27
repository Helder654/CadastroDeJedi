package dev.helder.CadastroDeJedi.Missoes;

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
import org.springframework.dao.DataIntegrityViolationException;

//LOCALHOST:8080/DELETAR
@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;
    
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissao(){
        List<MissoesDTO> missao = missoesService.listarMissoes();
        return ResponseEntity.ok(missao);
        
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarMissoesPorId(@PathVariable Long id){
        
        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if(missao != null ){
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.ok("Id de missão não encontrado");
        }
    }
    
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){

        MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Missão criado com sucesso! nome:" + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id,@RequestBody MissoesDTO missaoDTO) {
        
        MissoesDTO missao = missoesService.atualizarMissao(id, missaoDTO);

        if(missao != null){
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Missão não encontrado para ser alterado");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {

        if (missoesService.listarMissoesPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID " + id + " não encontrada.");
        }

        try {
            missoesService.deletarMissaoPorId(id);

            return ResponseEntity.ok(
                    "Missão com ID " + id + " deletada com sucesso!"
            );

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Não é possível excluir essa missão, pois ela está vinculada a um Jedi.");
        }
    }
}