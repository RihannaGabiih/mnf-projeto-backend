package mnf.projeto.service;

import mnf.projeto.entity.Comentario;
import mnf.projeto.entity.Noticia;
import mnf.projeto.repositories.ComentarioRepository;
import mnf.projeto.repositories.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private NoticiaRepository noticiaRepository;

    // Método: criar comentário
    public Comentario criarComentario(Comentario comentario) {
        // Regra de Negócio: Garante que a data de registro é a data atual
        comentario.setDataComentario(LocalDateTime.now());

        return comentarioRepository.save(comentario);
    }

    // Método: listar comentários de uma notícia
    public List<Comentario> listarComentariosPorNoticia(Long idNoticia) {
        Noticia noticia = noticiaRepository.findById(idNoticia)
                .orElseThrow(() -> new RuntimeException("Notícia não encontrada"));
        return comentarioRepository.findByNoticia(noticia);
    }

    // Método: apagar comentário
    public void apagarComentario(Long idComentario) {

        if (!comentarioRepository.existsById(idComentario)) {
            throw new RuntimeException("Comentário não encontrado");
        }
        comentarioRepository.deleteById(idComentario);
    }

    // Método: editar comentário
    public Comentario editarComentario(Long idComentario, String novoTexto) {
        Comentario comentario = comentarioRepository.findById(idComentario)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));

        comentario.setTexto(novoTexto);

        return comentarioRepository.save(comentario);
    }
}