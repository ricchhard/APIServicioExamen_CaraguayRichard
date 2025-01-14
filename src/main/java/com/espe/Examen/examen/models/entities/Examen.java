package com.espe.Examen.examen.models.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.util.Date;

@Entity
@Table(name = "examen")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede ser nulo.")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres.")
    @Column(nullable = false)
    private String nombre;

    @Min(value = 0, message = "La nota no puede ser menor a 0.")
    @Max(value = 10, message = "La nota no puede ser mayor a 10.")
    @Column(nullable = false)
    private int nota;

    @Past(message = "La fecha debe ser una fecha pasada.")
    @Column(nullable = false)
    private Date fecha;

    @NotNull(message = "La asignatura no puede ser nula.")
    @Size(min = 1, max = 100, message = "La asignatura debe tener entre 1 y 100 caracteres.")
    @Column(nullable = false)
    private String asignatura;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}
