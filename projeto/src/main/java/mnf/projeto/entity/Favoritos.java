package mnf.projeto.entity;



import jakarta.persistence.*;

@Entity
public class Favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private Long conteudoId;

    public Favoritos() {}

    public Favoritos(Long usuarioId, Long conteudoId) {
        this.usuarioId = usuarioId;
        this.conteudoId = conteudoId;
    }

    public Long getId() { return id; }
    public Long getUsuarioId() { return usuarioId; }
    public Long getConteudoId() { return conteudoId; }

    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public void setConteudoId(Long conteudoId) { this.conteudoId = conteudoId; }
}
