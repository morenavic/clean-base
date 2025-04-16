package curso.exception;

public class NivelRequeridoException extends RuntimeException {
    public NivelRequeridoException(String mensaje){
        super(mensaje);
    }
}