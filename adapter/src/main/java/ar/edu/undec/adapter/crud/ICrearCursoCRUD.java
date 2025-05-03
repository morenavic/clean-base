package ar.edu.undec.adapter.crud;

import ar.edu.undec.adapter.entity.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrearCursoCRUD extends CrudRepository<CursoEntity,Integer> {

}
