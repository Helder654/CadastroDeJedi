package dev.helder.CadastroDeJedi.Missoes;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {

    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Listar todas as missões
    @GetMapping("/listar")
    public String listarMissoes(Model model) {

        List<MissoesDTO> missoes = missoesService.listarMissoes();

        model.addAttribute("missoes", missoes);

        return "listarMissoes";
    }

    // Abrir formulário de criação
    @GetMapping("/adicionar")
    public String abrirFormularioAdicionar(Model model) {

        model.addAttribute("missao", new MissoesDTO());

        return "adicionarMissao";
    }

    // Salvar uma nova missão
    @PostMapping("/salvar")
    public String salvarMissao(
            @ModelAttribute("missao") MissoesDTO missao,
            RedirectAttributes redirectAttributes
    ) {

        missoesService.criarMissao(missao);

        redirectAttributes.addFlashAttribute(
                "mensagem",
                "Missão cadastrada com sucesso!"
        );

        return "redirect:/missoes/ui/listar";
    }

    // Mostrar detalhes
    @GetMapping("/listar/{id}")
    public String mostrarDetalhes(
            @PathVariable Long id,
            Model model,
            RedirectAttributes redirectAttributes
    ) {

        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao == null) {
            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Missão não encontrada."
            );

            return "redirect:/missoes/ui/listar";
        }

        model.addAttribute("missao", missao);

        return "detalhesMissao";
    }

    // Abrir formulário de alteração
    @GetMapping("/alterar/{id}")
    public String abrirFormularioAlterar(
            @PathVariable Long id,
            Model model,
            RedirectAttributes redirectAttributes
    ) {

        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao == null) {
            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Missão não encontrada."
            );

            return "redirect:/missoes/ui/listar";
        }

        model.addAttribute("missao", missao);

        return "alterarMissao";
    }

    // Atualizar uma missão
    @PostMapping("/atualizar/{id}")
    public String atualizarMissao(
            @PathVariable Long id,
            @ModelAttribute("missao") MissoesDTO missao,
            RedirectAttributes redirectAttributes
    ) {

        missao.setId(id);

        MissoesDTO missaoAtualizada =
                missoesService.atualizarMissao(id, missao);

        if (missaoAtualizada == null) {
            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Missão não encontrada para alteração."
            );

            return "redirect:/missoes/ui/listar";
        }

        redirectAttributes.addFlashAttribute(
                "mensagem",
                "Missão atualizada com sucesso!"
        );

        return "redirect:/missoes/ui/listar";
    }

    // Deletar uma missão
    @GetMapping("/delete/{id}")
    public String deletarMissao(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes
    ) {

        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao == null) {
            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Missão não encontrada."
            );

            return "redirect:/missoes/ui/listar";
        }

        try {
            missoesService.deletarMissaoPorId(id);

            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Missão deletada com sucesso!"
            );

        } catch (DataIntegrityViolationException e) {

            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Não é possível deletar essa missão, pois ela está vinculada a um Jedi."
            );
        }

        return "redirect:/missoes/ui/listar";
    }
}