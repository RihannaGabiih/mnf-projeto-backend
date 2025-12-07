package mnf.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mnf.projeto.entity.NaoVer;

import java.util.List;

public interface NaoVerRepository extends JpaRepository<NaoVer, Long> {

    List<NaoVer> findByUsuarioId(Long usuarioId);
}
