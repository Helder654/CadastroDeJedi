package dev.helder.CadastroDeJedi.Jedi.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jedi/ui")

public class JediControllerUi {

    private final JediService jediService;

    public JediControllerUi(JediService jediService) {
        this.jediService = jediService;
    }
    
    @GetMapping("/listar")
    public String mostrarTodosOsJedi(Model model){
        List<JediDTO> jediLista = jediService.listarJedi();  
        model.addAttribute("jedi", jediLista); 
        return "listarJedi";
    }
}
