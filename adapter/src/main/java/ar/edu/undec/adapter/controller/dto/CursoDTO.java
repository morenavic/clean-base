package ar.edu.undec.adapter.controller.dto;

import curso.modelo.Nivel;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) para representar los datos del Curso
 * que se envían o reciben por la capa de controlador.
 */
public class CursoDTO {

    private String nombre;
    private LocalDateTime fechaCierreInscripcion;
    private Nivel nivel;

    //Constructor vacío requerido por Spring
    public CursoDTO() {}

    //Constructor completo útil para crear el DTO
    public CursoDTO(String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel) {
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;
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
