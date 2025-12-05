package mnf.projeto.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mnf.projeto.entity.Like;
import mnf.projeto.entity.NaoVer;
import mnf.projeto.repositories.LikeRepository;

@Service
public class NaoVerService {

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

	public void adicionar(Long usuarioId, Long conteudoId) {
		// TODO Auto-generated method stub
		
	}

	public List<NaoVer> listar(Long usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}
}

