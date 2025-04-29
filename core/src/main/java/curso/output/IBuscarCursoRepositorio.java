package curso.output;

import curso.modelo.Curso;
import curso.modelo.Nivel;

import java.time.LocalDateTime;
import java.util.List;

public interface IBuscarCursoRepositorio {
    //Las búsquedas se realizarían en la base de datos
    List<Curso> buscarTodos();
    Curso buscarPorNombre(String nombre);
    List<Curso> buscarPorFecha(LocalDateTime fechaCierreInscripcion);
    List<Curso> buscarPorNivel(Nivel nivel);
}
