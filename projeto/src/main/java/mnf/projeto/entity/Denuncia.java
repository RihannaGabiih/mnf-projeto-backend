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
	public Long getIdDenuncia() {
		return idDenuncia;
	}
	public void setIdDenuncia(Long idDenuncia) {
		this.idDenuncia = idDenuncia;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public LocalDateTime getDataDenuncia() {
		return dataDenuncia;
	}
	public void setDataDenuncia(LocalDateTime dataDenuncia) {
		this.dataDenuncia = dataDenuncia;
	}
    
    
}