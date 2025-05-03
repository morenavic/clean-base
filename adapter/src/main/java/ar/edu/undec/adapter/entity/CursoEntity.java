package ar.edu.undec.adapter.entity;

import curso.modelo.Nivel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "cursos")
public class CursoEntity {

    @Id
    @Column(name = "id_curso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_cierre_inscripcion")
    private LocalDateTime fechaCierreInscripcion;
    @Column(name = "nivel")
    @Enumerated(EnumType.STRING) // Necesario por ser un tipo de dato creado por el usuario
    private Nivel nivel;

    public CursoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }

    public void setFechaCierreInscripcion(LocalDateTime fechaCierreInscripcion) {
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
