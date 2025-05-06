package ar.edu.undec.adapter.controller.exception;

import curso.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorExcepciones {

    @ExceptionHandler(CursoExisteException.class)
    public ResponseEntity<String> manejarCursoExistente(CursoExisteException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(FechaAnteriorException.class)
    public ResponseEntity<String> manejarFechaAnterior(FechaAnteriorException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(FechaRequeridaException.class)
    public ResponseEntity<String> manejarFechaRequerida(FechaRequeridaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(GuardarCursoException.class)
    public ResponseEntity<String> manejarGuardarCurso(GuardarCursoException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(NivelIncorrectoException.class)
    public ResponseEntity<String> manejarNivelIncorrecto(NivelIncorrectoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(NoExisteCursoException.class)
    public ResponseEntity<String> manejarNoExisteCurso(NoExisteCursoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(NombreRequeridoException.class)
    public ResponseEntity<String> manejarNombreRequerido(NombreRequeridoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    //Manejo genérico de errores por si se escapa algo no previsto
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcionGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: " + ex.getMessage());
    }
}
