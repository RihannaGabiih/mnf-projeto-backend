package mnf.projeto.service;

import mnf.projeto.entity.Noticia;
import mnf.projeto.entity.Fonte;
import mnf.projeto.repositories.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    public Noticia criar(Noticia noticia) {
        noticia.setDataCriacao(LocalDate.now());
        return noticiaRepository.save(noticia);
    }

    public List<Noticia> listarTodas() {
        return noticiaRepository.findAll();
    }

    public Noticia buscarPorId(Long id) {
        return noticiaRepository.findById(id).orElse(null);
    }

    public Noticia atualizar(Long id, Noticia noticia) {
        noticia.setId(id);
        return noticiaRepository.save(noticia);
    }

    public void deletar(Long id) {
        noticiaRepository.deleteById(id);
    }

    public List<Noticia> listarPorFonte(Fonte fonte) {
        return noticiaRepository.findByFonte(fonte);
    }

    public List<Noticia> listarPorTema(String tema) {
        return noticiaRepository.findByTema(tema);
    }

    public List<Noticia> listarPorTempo(LocalDate data) {
        return noticiaRepository.findByDataCriacaoAfter(data);
    }
}
