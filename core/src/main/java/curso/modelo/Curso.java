package curso.modelo;

import curso.exception.FechaRequeridaException;
import curso.exception.NombreRequeridoException;
import curso.exception.FechaAnteriorException;

import java.time.LocalDateTime;

public class Curso {

    private Integer id;
    private String nombre;
    private final LocalDateTime fechaCierreInscripcion;
    private Nivel nivel;

    public Curso(String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel) {
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;
    }

    //Factory Method
    public static Curso instancia(String nombre, LocalDateTime fecha_cierre_inscripcion, Nivel nivel) {
        if(nombre == null || nombre.isBlank()){
            throw new NombreRequeridoException("Nombre requerido.");
        }
        if(fecha_cierre_inscripcion == null){
            throw new FechaRequeridaException("Fecha requerida.");
        }
        if(fecha_cierre_inscripcion.isBefore(LocalDateTime.now())){
            throw new FechaAnteriorException("La fecha no puede ser anterior a la actual.");
        }

        return new Curso(nombre,fecha_cierre_inscripcion,nivel);
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
}