package dev.helder.CadastroDeJedi.Jedi.Controller;

import java.util.List;

import dev.helder.CadastroDeJedi.Missoes.MissoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("jedi/ui")

public class JediControllerUi {

    private final JediService jediService;
    private final MissoesService missoesService;
    
    public JediControllerUi(JediService jediService, MissoesService missoesService) {
        this.jediService = jediService;
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String mostrarTodosOsJedi(Model model){
        List<JediDTO> jediLista = jediService.listarJedi();  
        model.addAttribute("jedi", jediLista); 
        return "listarJedi";
    }

    @GetMapping("/delete/{id}")
    public String deletarJedi(@PathVariable Long id){
        jediService.deletarJediPorId(id);
        return "redirect:/jedi/ui/listar";
    }

        @GetMapping("/listar/{id}")
    public String mostrarOsJediPorId(@PathVariable Long id, Model model){

        JediDTO jedi = jediService.listarJediPorId(id);

        if(jedi != null){
            model.addAttribute("jedi", jedi); 
            return "detalhesJedi";
        }else{
            model.addAttribute("mensagem", "Jedi não encontrado"); 
            return "listarJedi";
        }
    }

        @GetMapping("/adicionar")
public String mostrarFormularioAdicionarJedi(Model model) {

    model.addAttribute("jedi", new JediDTO());

    model.addAttribute(
            "missoes",
            missoesService.listarMissoes()
    );

    return "adicionarJedi";
}

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute JediDTO ninja, RedirectAttributes redirectAttributes) {
        jediService.criarJedi(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Jedi cadastrado com sucesso!");
        return "redirect:/jedi/ui/listar";
    }

   @GetMapping("/alterar/{id}")
public String abrirFormularioAlterar(
        @PathVariable Long id,
        Model model
) {

    JediDTO jediDTO = jediService.listarJediPorId(id);

    if (jediDTO == null) {
        return "redirect:/jedi/ui/listar";
    }

    model.addAttribute("jedi", jediDTO);

    model.addAttribute(
            "missoes",
            missoesService.listarMissoes()
    );

    return "alterarJedi";
}

@PostMapping("/atualizar/{id}")
public String atualizarJedi(
        @PathVariable Long id,
        @ModelAttribute("jedi") JediDTO jediDTO
) {
    jediDTO.setId(id);

    jediService.atualizarJedi(id, jediDTO);

    return "redirect:/jedi/ui/listar";
}
}
