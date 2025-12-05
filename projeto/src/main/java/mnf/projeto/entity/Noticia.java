package mnf.projeto.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String resumo;
    private String tema;       
    private LocalDate dataCriacao;

    @ManyToOne
    private Fonte fonte;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getResumo() { return resumo; }
    public void setResumo(String resumo) { this.resumo = resumo; }
    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
    public Fonte getFonte() { return fonte; }
    public void setFonte(Fonte fonte) { this.fonte = fonte; }
}
