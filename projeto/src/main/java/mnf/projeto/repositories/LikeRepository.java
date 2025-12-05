package mnf.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mnf.projeto.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

    int countByConteudoId(Long conteudoId);
    boolean existsByUsuarioIdAndConteudoId(Long usuarioId, Long conteudoId);
}

