package mnf.projeto.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDenuncia;

    @ManyToOne 
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne 
    @JoinColumn(name = "id_noticia")
    private Noticia noticia;

    private String motivo;
    private LocalDateTime dataDenuncia;

}