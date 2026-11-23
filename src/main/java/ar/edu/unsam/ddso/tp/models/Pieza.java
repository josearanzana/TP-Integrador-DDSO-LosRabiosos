package ar.edu.unsam.ddso.tp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;

@Entity
public class Pieza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    @OneToMany(mappedBy = "pieza") // muchas digitalizaciones pertenecen a una pieza
    private List<Digitalizacion> digitalizaciones = new ArrayList<>();

    private LocalDate fechaAlta;

    public Pieza() {}

    public Pieza(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaAlta = LocalDate.now();
    }

    public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getDescripcion() {return descripcion;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public LocalDate getFechaAlta() {return fechaAlta;}
}