package mnf.projeto.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mnf.projeto.entity.Favoritos;
import mnf.projeto.repositories.FavoritoRepository;

import java.util.List;

@Service
public class FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    public void adicionarFavorito(Long usuarioId, Long conteudoId) {
        favoritoRepository.save(new Favoritos(usuarioId, conteudoId));
    }

    public List<Favoritos> listarFavoritos(Long usuarioId) {
        return favoritoRepository.findByUsuarioId(usuarioId);
    }
}
