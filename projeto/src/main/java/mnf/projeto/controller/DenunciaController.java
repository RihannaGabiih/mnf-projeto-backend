package mnf.projeto.controller;

import mnf.projeto.entity.Denuncia;
import mnf.projeto.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    // Endpoint: registrar denúncia
    // POST /denuncias
    @PostMapping
    public ResponseEntity<Denuncia> registrarDenuncia(@RequestBody Denuncia denuncia) {
        Denuncia novaDenuncia = denunciaService.registrarDenuncia(denuncia);
        return ResponseEntity.ok(novaDenuncia);
    }

    // Endpoint: listar denúncias (acesso administrativo)
    // GET /denuncias
    @GetMapping
    public ResponseEntity<List<Denuncia>> listarDenuncias() {
        List<Denuncia> denuncias = denunciaService.listarTodasDenuncias();
        return ResponseEntity.ok(denuncias);
    }

    // Endpoint: apagar denúncias (após resolução)
    // DELETE /denuncias/10
    @DeleteMapping("/{idDenuncia}")
    public ResponseEntity<Void> apagarDenuncia(@PathVariable Long idDenuncia) {
        denunciaService.apagarDenuncia(idDenuncia);
        return ResponseEntity.noContent().build();
    }
}