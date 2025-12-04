package mnf.projeto.controller;

import mnf.projeto.entity.Fonte;
import mnf.projeto.repositories.FonteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fontes")
public class FonteController {

    @Autowired
    private FonteRepository fonteRepository;

    // CREATE
    @PostMapping
    public Fonte criarFonte(@RequestBody Fonte fonte) {
        return fonteRepository.save(fonte);
    }

    // READ ALL
    @GetMapping
    public List<Fonte> listarFontes() {
        return fonteRepository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Optional<Fonte> buscarFontePorId(@PathVariable Long id) {
        return fonteRepository.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Fonte atualizarFonte(@PathVariable Long id, @RequestBody Fonte fonteAtualizada) {
        return fonteRepository.findById(id).map(fonte -> {
            fonte.setNomeFonte(fonteAtualizada.getNomeFonte());
            return fonteRepository.save(fonte);
        }).orElseGet(() -> {
            fonteAtualizada.setId(id);
            return fonteRepository.save(fonteAtualizada);
        });
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletarFonte(@PathVariable Long id) {
        fonteRepository.deleteById(id);
    }
}
