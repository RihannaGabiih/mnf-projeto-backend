package mnf.projeto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "likes") // <-- ESSENCIAL!
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "conteudo_id")
    private Long conteudoId;

    public Like() {}

    public Like(Long usuarioId, Long conteudoId) {
        this.usuarioId = usuarioId;
        this.conteudoId = conteudoId;
    }

    public Long getId() { return id; }
    public Long getUsuarioId() { return usuarioId; }
    public Long getConteudoId() { return conteudoId; }

    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public void setConteudoId(Long conteudoId) { this.conteudoId = conteudoId; }
}
