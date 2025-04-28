package model;

import curso.exception.FechaRequeridaException;
import curso.exception.NombreRequeridoException;
import curso.exception.FechaAnteriorException;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CursoTest {

    @Test
    void instanciarCurso_TodosLosAtributos_IntanciaCorrecta(){
        Curso curso = Curso.instancia("Clean Architecture", LocalDateTime.now().plusDays(5) , Nivel.INICIAL);

        Assertions.assertEquals("Clean Architecture",curso.getNombre());
    }
    @Test
    void instanciarCurso_NombreVacio_CursoIncompleto(){
        Assertions.assertThrows(NombreRequeridoException.class,
                ()-> Curso.instancia("", LocalDateTime.now().plusDays(5) ,Nivel.INICIAL));
    }
    @Test
    void instanciarCurso_NombreConEspacio_CursoIncompleto(){
        Assertions.assertThrows(NombreRequeridoException.class,
                ()-> Curso.instancia(" ", LocalDateTime.now().plusDays(5) ,Nivel.INICIAL));
    }
    @Test
    void instanciarCurso_NombreNulo_CursoIncompleto(){
        Assertions.assertThrows(NombreRequeridoException.class,
                ()-> Curso.instancia(null, LocalDateTime.now().plusDays(5) ,Nivel.INICIAL));
    }
    @Test
    void instanciarCurso_FechaNula_CursoIncompleto(){
        Assertions.assertThrows(FechaRequeridaException.class,
                ()-> Curso.instancia("Clean Architecture", null ,Nivel.INICIAL));
    }
    @Test
    void instanciarCurso_FechaAnterior_CursoIncompleto(){
        Assertions.assertThrows(FechaAnteriorException.class,
                ()-> Curso.instancia("Clean Architecture", LocalDateTime.now().minusDays(2) ,Nivel.INICIAL));
    }

}