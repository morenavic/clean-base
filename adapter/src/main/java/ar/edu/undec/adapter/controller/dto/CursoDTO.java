package ar.edu.undec.adapter.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import curso.modelo.Curso;
import curso.modelo.Nivel;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) para representar los datos del Curso
 * que se envían o reciben por la capa de controlador.
 */
public class CursoDTO {

    private final String nombre;
    private final LocalDateTime fechaCierreInscripcion;
    private final Nivel nivel;

    //Constructor completo útil para crear el DTO
    /**
     * Jackson -> librería de serialización/deserialización JSON en Java.
     * JsonProperty (anotación Jackson) -> para mapear datos de campos JSON
     * a atributos del objeto sin necesidad de setters.
     * También sirve para renombrar propiedades.
     */
    public CursoDTO(@JsonProperty("nombre") String nombre, @JsonProperty("fechaCierreInscripcion") LocalDateTime fechaCierreInscripcion,  @JsonProperty("nivel") Nivel nivel) {
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }

    public Nivel getNivel() {
        return nivel;
    }

    //Metodo para convertir un objeto Curso en un objeto CursoDTO.
    public static CursoDTO desdeCurso(Curso curso) {
        return new CursoDTO(
                curso.getNombre(),
                curso.getFechaCierreInscripcion(),
                curso.getNivel()
        );
    }

    //Metodo para convertir un objeto CursoDTO en un objeto Curso.
    public static Curso aCurso(CursoDTO cursoDTO) {
        return Curso.instancia(
                cursoDTO.getNombre(),
                cursoDTO.getFechaCierreInscripcion(),
                cursoDTO.getNivel()
        );
    }
}
