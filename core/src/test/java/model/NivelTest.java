package model;

import curso.exception.NivelIncorrectoException;
import curso.exception.NivelRequeridoException;
import curso.modelo.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NivelTest {
    @Test
    void instanciarCurso_NivelVacio_CursoIncompleto(){
        Exception miExc = Assertions.assertThrows(NivelRequeridoException.class,
                ()-> Nivel.validarNivel(""));
        Assertions.assertEquals("Nivel requerido.",miExc.getMessage());
    }
    @Test
    void instanciarCurso_NivelConEspacio_CursoIncompleto(){
        Exception miExc = Assertions.assertThrows(NivelRequeridoException.class,
                ()-> Nivel.validarNivel(" "));
        Assertions.assertEquals("Nivel requerido.",miExc.getMessage());
    }
    @Test
    void instanciarCurso_NivelNulo_CursoIncompleto(){
        Exception miExc = Assertions.assertThrows(NivelRequeridoException.class,
                ()-> Nivel.validarNivel(null));
        Assertions.assertEquals("Nivel requerido.",miExc.getMessage());
    }
    @Test
    void instanciarCurso_NivelIncorrecto_CursoIncompleto(){
        String nivelString = "Super experto";
        Exception miExc = Assertions.assertThrows(NivelIncorrectoException.class,
                ()-> Nivel.validarNivel(nivelString));
        Assertions.assertEquals("El nivel " + nivelString + " es incorrecto.",miExc.getMessage());
    }
}