package model;

import curso.exception.FechaRequeridaException;
import curso.exception.NombreRequeridoException;
import curso.exception.FechaAnteriorException;
import curso.modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CursoTest {

    @Test
    void instanciarCurso_TodosLosAtributos_IntanciaCorrecta(){
        Curso curso = Curso.instancia("Clean Architecture", LocalDateTime.now().plusDays(5) ,"Inicial");

        Assertions.assertEquals("Clean Architecture",curso.getNombre());
    }
    @Test
    void instanciarCurso_NombreVacio_CursoIncompleto(){
        Exception miExc = Assertions.assertThrows(NombreRequeridoException.class,
                ()-> Curso.instancia("", LocalDateTime.now().plusDays(5) ,"Inicial"));
        Assertions.assertEquals("Nombre requerido.",miExc.getMessage());
    }
    @Test
    void instanciarCurso_NombreConEspacio_CursoIncompleto(){
        Exception miExc = Assertions.assertThrows(NombreRequeridoException.class,
                ()-> Curso.instancia(" ", LocalDateTime.now().plusDays(5) ,"Inicial"));
        Assertions.assertEquals("Nombre requerido.",miExc.getMessage());
    }
    @Test
    void instanciarCurso_NombreNulo_CursoIncompleto(){
        Exception miExc = Assertions.assertThrows(NombreRequeridoException.class,
                ()-> Curso.instancia(null, LocalDateTime.now().plusDays(5) ,"Inicial"));
        Assertions.assertEquals("Nombre requerido.",miExc.getMessage());
    }
    @Test
    void instanciarCurso_FechaNula_CursoIncompleto(){
        Exception miExc = Assertions.assertThrows(FechaRequeridaException.class,
                ()-> Curso.instancia("Clean Architecture", null ,"Inicial"));
        Assertions.assertEquals("Fecha requerida.",miExc.getMessage());
    }
    @Test
    void instanciarCurso_FechaAnterior_CursoIncompleto(){
        Exception miExc = Assertions.assertThrows(FechaAnteriorException.class,
                ()-> Curso.instancia("Clean Architecture", LocalDateTime.now().minusDays(2) ,"Inicial"));
        Assertions.assertEquals("La fecha no puede ser anterior a la actual.",miExc.getMessage());
    }

}