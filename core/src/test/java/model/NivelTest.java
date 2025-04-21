package model;

import curso.exception.NivelIncorrectoException;
import curso.exception.NivelRequeridoException;
import curso.modelo.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NivelTest {
    @Test
    void instanciarCurso_NivelVacio_CursoIncompleto(){
        Assertions.assertThrows(NivelRequeridoException.class,
                ()-> Nivel.validarNivel(""));
    }
    @Test
    void instanciarCurso_NivelConEspacio_CursoIncompleto(){
        Assertions.assertThrows(NivelRequeridoException.class,
                ()-> Nivel.validarNivel(" "));
    }
    @Test
    void instanciarCurso_NivelNulo_CursoIncompleto(){
        Assertions.assertThrows(NivelRequeridoException.class,
                ()-> Nivel.validarNivel(null));
    }
    @Test
    void instanciarCurso_NivelIncorrecto_CursoIncompleto(){
        String nivelString = "Super experto";
        Assertions.assertThrows(NivelIncorrectoException.class,
                ()-> Nivel.validarNivel(nivelString));
    }
}