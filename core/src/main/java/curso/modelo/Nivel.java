package curso.modelo;

import curso.exception.NivelIncorrectoException;
import curso.exception.NivelRequeridoException;

public enum Nivel {
    INICIAL,
    MEDIO,
    AVANZADO;

    public static Nivel validarNivel(String nivelString) {

        if(nivelString==null || nivelString.isBlank()){
            throw new NivelRequeridoException("Nivel requerido.");
        }

        String nivelMayus = nivelString.toUpperCase();
        for (Nivel nivel : Nivel.values()) {
            if (nivel.name().equals(nivelMayus)) {
                return nivel;
            }
        }
        throw new NivelIncorrectoException("El nivel " + nivelString + " es incorrecto.");
    }
}