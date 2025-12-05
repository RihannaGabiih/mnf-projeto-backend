package mnf.projeto.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Fonte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "fonte")
    private List<Noticia> noticias;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Noticia> getNoticias() { return noticias; }
    public void setNoticias(List<Noticia> noticias) { this.noticias = noticias; }
}
