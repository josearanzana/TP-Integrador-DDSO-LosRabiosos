package ar.edu.unsam.ddso.tp.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Digitalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String descripcion;

    @ManyToOne
    private Pieza pieza;

    @ManyToMany
    private Set<Tag> tags = new HashSet<>();

    public Digitalizacion() {}

    public Digitalizacion(String url, String descripcion) {
        this.url = url;
        this.descripcion = descripcion;
    }

    public Long getId() {return id;}
    public String getUrl() {return url;}
    public String getDescripcion() {return descripcion;}
    public Pieza getPieza() {return pieza;}
    public void setPieza(Pieza pieza) {this.pieza = pieza;}
    public void setUrl(String url) {this.url = url;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public Set<Tag> getTags() {return tags;}
    public void agregarTag(Tag tag) {tags.add(tag);}
}