package ar.edu.undec.adapter.entity;

import curso.modelo.Nivel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "cursos") //Marca esta clase como una entidad de base de datos
public class CursoEntity {

    @Id
    @Column(name = "id_curso")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incremental
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_cierre_inscripcion")
    private LocalDateTime fechaCierreInscripcion;
    @Column(name = "nivel")
    @Enumerated(EnumType.STRING) //Guarda el enum como texto en la base de datos
    private Nivel nivel;

    //Constructor vacío requerido por JPA
    public CursoEntity() {
    }

    public CursoEntity(Integer id, String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;
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
