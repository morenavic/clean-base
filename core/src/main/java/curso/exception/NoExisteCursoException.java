package curso.exception;

public class NoExisteCursoException extends RuntimeException {
    public NoExisteCursoException(String mensaje) {
        super(mensaje);
    }
}
