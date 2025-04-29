package curso.output;

import curso.modelo.Curso;

public interface ICrearCursoRepositorio {
    boolean existe(String nombre);
    boolean guardar(Curso curso);
}