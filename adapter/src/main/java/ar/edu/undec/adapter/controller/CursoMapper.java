package ar.edu.undec.adapter.controller;

import ar.edu.undec.adapter.entity.CursoEntity;
import curso.modelo.Curso;

import java.util.Collection;
import java.util.stream.Collectors;

public class CursoMapper {

    //Metodo para convertir una colección CursoEntity a Curso
    public static Collection<Curso> convertirAColeccionDeModelo(Collection<CursoEntity> cursoEntities) {
        return cursoEntities.stream()
                .map(CursoMapper::convertirAModelo)
                .collect(Collectors.toList());
    }

    //Metodo para convertir una sola CursoEntity a Curso
    public static Curso convertirAModelo(CursoEntity cursoEntity) {
        if (cursoEntity == null) return null;
        return Curso.instancia(
                cursoEntity.getNombre(),
                cursoEntity.getFechaCierreInscripcion(),
                cursoEntity.getNivel()
        );
    }
}
