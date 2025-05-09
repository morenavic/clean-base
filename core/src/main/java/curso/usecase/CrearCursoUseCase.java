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

        //Si el curso existe se arroja una excepción
        if(iCrearCursoRepositorio.existe(curso.getNombre())){
            throw new CursoExisteException("El curso ya existe.");
        }

        // Si por algún motivo no se pudo guardar el curso se arroja una excepción
        if(!iCrearCursoRepositorio.guardar(curso)){
            throw new GuardarCursoException("No se pudo guardar el curso.");
        }

        return true;
    }
}