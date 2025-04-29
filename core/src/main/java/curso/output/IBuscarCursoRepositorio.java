package curso.output;

import curso.modelo.Curso;
import curso.modelo.Nivel;

import java.time.LocalDateTime;
import java.util.Collection;

public interface IBuscarCursoRepositorio {
    //Las búsquedas se realizarían en la base de datos
    Collection<Curso> buscarTodos();
    Curso buscarPorNombre(String nombre);
    Collection<Curso> buscarPorFecha(LocalDateTime fechaCierreInscripcion);
    Collection<Curso> buscarPorNivel(Nivel nivel);
}
