package mnf.projeto.repositories;

import mnf.projeto.entity.Comentario;
import mnf.projeto.entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    // Método customizado para listar comentários de uma notícia
    List<Comentario> findByNoticia(Noticia noticia);
}