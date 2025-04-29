package curso.input;

import curso.modelo.Curso;
import curso.modelo.Nivel;

import java.time.LocalDateTime;
import java.util.List;

public interface IBuscarCursoInput {
    List<Curso> buscarTodosLosCursos();
    Curso buscarCursoPorNombre(String nombre);
    List<Curso> buscarCursoPorFecha(LocalDateTime fechaCierreInscripcion);
    List<Curso> buscarCursoPorNivel(Nivel nivelBuscado);
}
