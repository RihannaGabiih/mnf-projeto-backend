package mnf.projeto.entity;

import jakarta.persistence.*;

@Entity
public class Fonte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFonte;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeFonte() { return nomeFonte; }
    public void setNomeFonte(String nomeFonte) { this.nomeFonte = nomeFonte; }
}
