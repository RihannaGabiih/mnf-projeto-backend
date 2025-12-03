package mnf.projeto.controller;

import mnf.projeto.entity.Comentario;
import mnf.projeto.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // Endpoint: criar comentário
    // POST /comentarios
    @PostMapping
    public ResponseEntity<Comentario> criarComentario(@RequestBody Comentario comentario) {
        Comentario novoComentario = comentarioService.criarComentario(comentario);
        return ResponseEntity.ok(novoComentario);
    }

    // Endpoint: listar comentários de uma notícia
    // GET /comentarios/noticia/1
    @GetMapping("/noticia/{idNoticia}")
    public ResponseEntity<List<Comentario>> listarComentariosPorNoticia(@PathVariable Long idNoticia) {
        List<Comentario> comentarios = comentarioService.listarComentariosPorNoticia(idNoticia);
        return ResponseEntity.ok(comentarios);
    }

    // Endpoint: apagar comentário
    // DELETE /comentarios/5
    @DeleteMapping("/{idComentario}")
    public ResponseEntity<Void> apagarComentario(@PathVariable Long idComentario) {
        comentarioService.apagarComentario(idComentario);
        return ResponseEntity.noContent().build();
    }

    // Endpoint: editar comentário
    // PUT /comentarios/5
    @PutMapping("/{idComentario}")
    public ResponseEntity<Comentario> editarComentario(
            @PathVariable Long idComentario,
            @RequestBody Comentario comentarioAtualizado) { 
        Comentario comentario = comentarioService.editarComentario(idComentario, comentarioAtualizado.getTexto());
        return ResponseEntity.ok(comentario);
    }
}