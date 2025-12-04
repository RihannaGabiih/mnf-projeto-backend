package mnf.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mnf.projeto.service.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/{usuarioId}/{conteudoId}")
    public String darLike(@PathVariable Long usuarioId, @PathVariable Long conteudoId) {
        likeService.darLike(usuarioId, conteudoId);
        return "Like registrado!";
    }

    @GetMapping("/count/{conteudoId}")
    public int contarLikes(@PathVariable Long conteudoId) {
        return likeService.contarLikes(conteudoId);
    }
}
