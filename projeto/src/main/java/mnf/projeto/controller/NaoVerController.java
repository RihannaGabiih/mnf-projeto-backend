package mnf.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mnf.projeto.entity.NaoVer;
import mnf.projeto.service.NaoVerService;

import java.util.List;

@RestController
@RequestMapping("/nao-ver")
public class NaoVerController {

    @Autowired
    private NaoVerService naoVerService;

    @PostMapping("/{usuarioId}/{conteudoId}")
    public String adicionar(@PathVariable Long usuarioId, @PathVariable Long conteudoId) {
        naoVerService.adicionar(usuarioId, conteudoId);
        return "Conteúdo marcado como 'não ver'.";
    }

    @GetMapping("/{usuarioId}")
    public List<NaoVer> listar(@PathVariable Long usuarioId) {
        return naoVerService.listar(usuarioId);
    }
}
