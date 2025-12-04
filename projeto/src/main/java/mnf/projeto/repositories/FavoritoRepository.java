package mnf.projeto.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import mnf.projeto.entity.Favoritos;

import java.util.List;

public interface FavoritoRepository extends JpaRepository<Favoritos, Long> {

    List<Favoritos> findByUsuarioId(Long usuarioId);
}
