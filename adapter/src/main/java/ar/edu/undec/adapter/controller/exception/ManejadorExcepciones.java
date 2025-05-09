package ar.edu.undec.adapter.controller.exception;

import curso.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorExcepciones {

    //Excepción que retorna -> HttpStatus.CONFLICT
    @ExceptionHandler(CursoExisteException.class)
    public ResponseEntity<String> manejarCursoExistente(CursoExisteException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    //Excepciónes que retornan -> HttpStatus.BAD_REQUEST
    @ExceptionHandler({FechaAnteriorException.class,
            FechaRequeridaException.class,
            NivelIncorrectoException.class,
            NombreRequeridoException.class
    })
    public ResponseEntity<String> manejarErroresDeValidaciones(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    //Excepción que retorna -> HttpStatus.INTERNAL_SERVER_ERROR
    @ExceptionHandler(GuardarCursoException.class)
    public ResponseEntity<String> manejarGuardarCurso(GuardarCursoException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    //Excepción que retorna -> HttpStatus.NOT_FOUND
    @ExceptionHandler(NoExisteCursoException.class)
    public ResponseEntity<String> manejarNoExisteCurso(NoExisteCursoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
