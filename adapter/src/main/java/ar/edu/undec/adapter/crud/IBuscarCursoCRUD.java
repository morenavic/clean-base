package ar.edu.undec.adapter.crud;

import ar.edu.undec.adapter.entity.CursoEntity;
import curso.modelo.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;

//Interfaz para acceder a la base de datos de cursos
public interface IBuscarCursoCRUD extends JpaRepository<CursoEntity, Integer> {
    //Buscar curso por nombre
    CursoEntity findByNombre(String nombre);
    //Buscar cursos por fecha posteriores a la de cierre de inscripción
    Collection<CursoEntity> findByFechaCierreInscripcionAfter(LocalDateTime fecha);
    //Buscar cursos por nivel (INICIAL, MEDIO, AVANZADO)
    Collection<CursoEntity> findByNivel(Nivel nivel);
}

