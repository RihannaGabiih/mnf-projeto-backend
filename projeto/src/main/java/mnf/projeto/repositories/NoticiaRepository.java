package mnf.projeto.repositories;

import mnf.projeto.entity.Noticia;
import mnf.projeto.entity.Fonte;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    List<Noticia> findByFonte(Fonte fonte);       // listar por fonte
    List<Noticia> findByTema(String tema);        // listar por tema
    List<Noticia> findByDataCriacaoAfter(LocalDate data); // listar por tempo
}
