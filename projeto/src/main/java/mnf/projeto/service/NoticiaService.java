package mnf.projeto.service;

import mnf.projeto.entity.Noticia;
import mnf.projeto.repositories.NoticiaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository repository;

    public Noticia salvar(Noticia noticia) {
        return repository.save(noticia);
    }

    public List<Noticia> listarTodas() {
        return repository.findAll();
    }

    public Noticia buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
