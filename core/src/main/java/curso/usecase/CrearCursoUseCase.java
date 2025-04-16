package curso.usecase;

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
            return false;
        }else{
            iCrearCursoRepositorio.guardar(curso);
            return true;
        }
    }
}