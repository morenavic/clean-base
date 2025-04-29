package curso.usecase;

import curso.exception.NoExisteCursoException;
import curso.input.IBuscarCursoInput;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.output.IBuscarCursoRepositorio;

import java.time.LocalDateTime;
import java.util.Collection;

public class BuscarCursoUseCase implements IBuscarCursoInput {

    private final IBuscarCursoRepositorio iBuscarCursoRepositorio;

    public BuscarCursoUseCase(IBuscarCursoRepositorio iBuscarCursoRepositorio){
        this.iBuscarCursoRepositorio = iBuscarCursoRepositorio;
    }


    @Override
    public Collection<Curso> buscarTodosLosCursos() {
        if(iBuscarCursoRepositorio.buscarTodos().isEmpty()){
            throw new NoExisteCursoException("No hay cursos para listar.");
        }
        return iBuscarCursoRepositorio.buscarTodos();
    }

    @Override
    public Curso buscarCursoPorNombre(String nombre) {
        Curso curso = iBuscarCursoRepositorio.buscarPorNombre(nombre);

        if(curso == null){
            throw new NoExisteCursoException("No existe un curso con ese nombre.");
        }

        return curso;
    }

    @Override
    public Collection<Curso> buscarCursoPorFecha(LocalDateTime fechaCierreInscripcion) {
        Collection<Curso> curso = iBuscarCursoRepositorio.buscarPorFecha(fechaCierreInscripcion);

        if(curso == null || curso.isEmpty()){
            throw new NoExisteCursoException("No existe un curso con fecha posterior a esta.");
        }

        return curso;
    }

    @Override
    public Collection<Curso> buscarCursoPorNivel(Nivel nivelBuscado) {
        Collection<Curso> curso = iBuscarCursoRepositorio.buscarPorNivel(nivelBuscado);

        if(curso == null || curso.isEmpty()){
            throw new NoExisteCursoException("No existe un curso con ese nivel.");
        }

        return curso;
    }
}
