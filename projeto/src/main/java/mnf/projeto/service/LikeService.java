package mnf.projeto.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mnf.projeto.entity.Like;
import mnf.projeto.repositories.LikeRepository;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public void darLike(Long usuarioId, Long conteudoId) {

        if (likeRepository.existsByUsuarioIdAndConteudoId(usuarioId, conteudoId)) {
            throw new RuntimeException("O usuário já deu like nesse conteúdo.");
        }

        likeRepository.save(new Like(usuarioId, conteudoId));
    }

    public int contarLikes(Long conteudoId) {
        return likeRepository.countByConteudoId(conteudoId);
    }
}

