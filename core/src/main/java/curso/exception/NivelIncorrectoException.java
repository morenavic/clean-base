package curso.exception;

public class NivelIncorrectoException extends RuntimeException {
    public NivelIncorrectoException(String mensaje){
        super(mensaje);
    }
}