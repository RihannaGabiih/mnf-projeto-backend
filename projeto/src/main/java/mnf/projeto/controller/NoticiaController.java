package mnf.projeto.controller;

import mnf.projeto.entity.Noticia;
import mnf.projeto.entity.Fonte;
import mnf.projeto.service.NoticiaService;
import mnf.projeto.service.FonteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @Autowired
    private FonteService fonteService;

    @PostMapping
    public ResponseEntity<Noticia> criar(@RequestBody Noticia noticia) {
        return ResponseEntity.ok(noticiaService.criar(noticia));
    }

    @GetMapping
    public ResponseEntity<List<Noticia>> listarTodas() {
        return ResponseEntity.ok(noticiaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticia> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(noticiaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> atualizar(@PathVariable Long id, @RequestBody Noticia noticia) {
        return ResponseEntity.ok(noticiaService.atualizar(id, noticia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        noticiaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/fonte/{nome}")
    public ResponseEntity<List<Noticia>> listarPorFonte(@PathVariable String nome) {
        Fonte fonte = fonteService.buscarPorNome(nome);
        if (fonte != null) {
            return ResponseEntity.ok(noticiaService.listarPorFonte(fonte));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/tema/{tema}")
    public ResponseEntity<List<Noticia>> listarPorTema(@PathVariable String tema) {
        return ResponseEntity.ok(noticiaService.listarPorTema(tema));
    }

    @GetMapping("/tempo/{data}")
    public ResponseEntity<List<Noticia>> listarPorTempo(@PathVariable String data) {
        LocalDate localDate = LocalDate.parse(data); // formato yyyy-MM-dd
        return ResponseEntity.ok(noticiaService.listarPorTempo(localDate));
    }
}
