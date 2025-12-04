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
    private LocalDate dataPublicacao;

    @ManyToOne
    private Fonte fonte;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getResumo() { return resumo; }
    public void setResumo(String resumo) { this.resumo = resumo; }
    public LocalDate getDataPublicacao() { return dataPublicacao; }
    public void setDataPublicacao(LocalDate dataPublicacao) { this.dataPublicacao = dataPublicacao; }
    public Fonte getFonte() { return fonte; }
    public void setFonte(Fonte fonte) { this.fonte = fonte; }
}