package curso.input;

import curso.modelo.Curso;
import curso.modelo.Nivel;

import java.time.LocalDateTime;
import java.util.Collection;

public interface IBuscarCursoInput {
    Collection<Curso> buscarTodosLosCursos();
    Curso buscarCursoPorNombre(String nombre);
    Collection<Curso> buscarCursoPorFecha(LocalDateTime fechaCierreInscripcion);
    Collection<Curso> buscarCursoPorNivel(Nivel nivelBuscado);
}
