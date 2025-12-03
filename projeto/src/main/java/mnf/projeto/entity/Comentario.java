package mnf.projeto.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    @ManyToOne 
    @JoinColumn(name = "id_usuario") 
    private Usuario usuario;

    @ManyToOne 
    @JoinColumn(name = "id_noticia") 
    private Noticia noticia;

    private String texto;
    private LocalDateTime dataComentario;

}