package mnf.projeto.controller;

import mnf.projeto.entity.Noticia;
import mnf.projeto.repositories.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaRepository noticiaRepository;

    // CREATE - Cadastrar uma nova notícia
    @PostMapping
    public Noticia criarNoticia(@RequestBody Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    // READ - Listar todas as notícias
    @GetMapping
    public List<Noticia> listarNoticias() {
        return noticiaRepository.findAll();
    }

    // READ - Buscar notícia por ID
    @GetMapping("/{id}")
    public Noticia buscarNoticiaPorId(@PathVariable Long id) {
        return noticiaRepository.findById(id).orElse(null);
    }

    // UPDATE - Atualizar notícia por ID
    @PutMapping("/{id}")
    public Noticia atualizarNoticia(@PathVariable Long id, @RequestBody Noticia noticiaAtualizada) {
        return noticiaRepository.findById(id).map(noticia -> {
            noticia.setTitulo(noticiaAtualizada.getTitulo());
            noticia.setResumo(noticiaAtualizada.getResumo());
            noticia.setDataPublicacao(noticiaAtualizada.getDataPublicacao());
            noticia.setFonte(noticiaAtualizada.getFonte());
            return noticiaRepository.save(noticia);
        }).orElseGet(() -> {
            noticiaAtualizada.setId(id);
            return noticiaRepository.save(noticiaAtualizada);
        });
    }

    // DELETE - Excluir notícia por ID
    @DeleteMapping("/{id}")
    public void deletarNoticia(@PathVariable Long id) {
        noticiaRepository.deleteById(id);
    }
}
