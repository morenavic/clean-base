package curso.usecase;

import curso.exception.CursoExisteException;
import curso.exception.GuardarCursoException;
import curso.input.ICrearCursoInput;
import curso.modelo.Curso;
import curso.output.ICrearCursoRepositorio;

public class CrearCursoUseCase implements ICrearCursoInput {

    private final ICrearCursoRepositorio iCrearCursoRepositorio;

    public CrearCursoUseCase(ICrearCursoRepositorio iCrearCursoRepositorio) {
        this.iCrearCursoRepositorio = iCrearCursoRepositorio;
    }

    @Override
    public boolean crearCurso(Curso curso) {
        if(iCrearCursoRepositorio.existe(curso.getNombre())){
            throw new CursoExisteException("El curso ya existe.");
        }

        // Capturo el valor que retorna el metodo guardar() y arrojo una excepción de ser necesario.
        boolean cursoGuardado = iCrearCursoRepositorio.guardar(curso);

        if(!cursoGuardado){
            throw new GuardarCursoException("No se pudo guardar el curso.");
        }

        return true;
    }
}