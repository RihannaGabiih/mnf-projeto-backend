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
	public Long getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDateTime getDataComentario() {
		return dataComentario;
	}
	public void setDataComentario(LocalDateTime dataComentario) {
		this.dataComentario = dataComentario;
	}
    
    
}