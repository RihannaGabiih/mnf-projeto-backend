package mnf.projeto.service;

import mnf.projeto.entity.Denuncia;
import mnf.projeto.repositories.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    // Método: registrar denúncia
    public Denuncia registrarDenuncia(Denuncia denuncia) {
        
        denuncia.setDataDenuncia(LocalDateTime.now());
        return denunciaRepository.save(denuncia);
    }

    // Método: listar denúncias (para painel administrativo)
    public List<Denuncia> listarTodasDenuncias() {
        return denunciaRepository.findAll();
    }

    // Método: apagar denúncias (após análise/resolução)
    public void apagarDenuncia(Long idDenuncia) {
       
        if (!denunciaRepository.existsById(idDenuncia)) {
            throw new RuntimeException("Denúncia não encontrada");
        }
        denunciaRepository.deleteById(idDenuncia);
    }
}