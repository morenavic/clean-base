package curso.exception;

public class FechaRequeridaException extends RuntimeException {
    public FechaRequeridaException(String mensaje){
        super(mensaje);
    }
}