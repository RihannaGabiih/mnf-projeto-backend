package mnf.projeto.controller;

import mnf.projeto.entity.Fonte;
import mnf.projeto.service.FonteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fontes")
public class FonteController {

    @Autowired
    private FonteService fonteService;

    @PostMapping
    public ResponseEntity<Fonte> criar(@RequestBody Fonte fonte) {
        return ResponseEntity.ok(fonteService.criar(fonte));
    }

    @GetMapping
    public ResponseEntity<List<Fonte>> listarTodas() {
        return ResponseEntity.ok(fonteService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fonte> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fonteService.buscarPorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Fonte> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(fonteService.buscarPorNome(nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fonte> atualizar(@PathVariable Long id, @RequestBody Fonte fonte) {
        return ResponseEntity.ok(fonteService.atualizar(id, fonte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        fonteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
