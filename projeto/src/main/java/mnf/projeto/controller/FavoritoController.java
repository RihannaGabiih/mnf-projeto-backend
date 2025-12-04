package mnf.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mnf.projeto.entity.Favoritos;
import mnf.projeto.service.FavoritoService;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @PostMapping("/{usuarioId}/{conteudoId}")
    public String favoritar(@PathVariable Long usuarioId, @PathVariable Long conteudoId) {
        favoritoService.adicionarFavorito(usuarioId, conteudoId);
        return "Conteúdo favoritado!";
    }

    @GetMapping("/{usuarioId}")
    public List<Favoritos> listar(@PathVariable Long usuarioId) {
        return favoritoService.listarFavoritos(usuarioId);
    }
}
