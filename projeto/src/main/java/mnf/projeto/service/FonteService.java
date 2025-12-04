package mnf.projeto.service;

import mnf.projeto.entity.Fonte;
import mnf.projeto.repositories.FonteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class FonteService {

    @Autowired
    private FonteRepository repository;

    public Fonte salvar(Fonte fonte) {
        return repository.save(fonte);
    }

    public List<Fonte> listarTodas() {
        return repository.findAll();
    }

    public Fonte buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
