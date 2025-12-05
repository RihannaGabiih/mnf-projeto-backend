package mnf.projeto.service;

import mnf.projeto.entity.Fonte;
import mnf.projeto.repositories.FonteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FonteService {

    @Autowired
    private FonteRepository fonteRepository;

    public Fonte criar(Fonte fonte) {
        return fonteRepository.save(fonte);
    }

    public List<Fonte> listarTodas() {
        return fonteRepository.findAll();
    }

    public Fonte buscarPorId(Long id) {
        return fonteRepository.findById(id).orElse(null);
    }

    public Fonte buscarPorNome(String nome) {
        return fonteRepository.findByNome(nome);
    }

    public Fonte atualizar(Long id, Fonte fonte) {
        fonte.setId(id);
        return fonteRepository.save(fonte);
    }

    public void deletar(Long id) {
        fonteRepository.deleteById(id);
    }
}
