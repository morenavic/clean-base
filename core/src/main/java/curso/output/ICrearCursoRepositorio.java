package curso.output;

import curso.exception.CursoExisteException;
import curso.modelo.Curso;

public interface ICrearCursoRepositorio {
    boolean existe(String nombre);
    boolean guardar(Curso curso);
}