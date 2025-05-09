package ar.edu.undec.adapter.crud;

import ar.edu.undec.adapter.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Interfaz para crear cursos en la base de datos
public interface ICrearCursoCRUD extends JpaRepository<CursoEntity, Integer> {
    //Verifica si ya existe un curso con ese nombre
    boolean existsByNombre(String nombre);
}
