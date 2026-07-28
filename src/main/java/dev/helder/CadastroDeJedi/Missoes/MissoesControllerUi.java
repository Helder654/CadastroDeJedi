package dev.helder.CadastroDeJedi.Missoes;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {

    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarMissao(Model model) {

        List<MissoesDTO> missao = missoesService.listarMissoes();

        model.addAttribute("missoes", missao);

        return "listarMissoes";
    }
}