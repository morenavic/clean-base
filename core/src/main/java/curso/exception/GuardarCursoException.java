package curso.exception;

public class GuardarCursoException extends RuntimeException {
    public GuardarCursoException(String mensaje) {
        super(mensaje);
    }
}
