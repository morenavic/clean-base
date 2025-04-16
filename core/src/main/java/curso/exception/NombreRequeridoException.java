package curso.exception;

public class NombreRequeridoException extends RuntimeException {
    public NombreRequeridoException(String mensaje){
        super(mensaje);
    }
}