package ar.edu.undec.adapter.repository;

import ar.edu.undec.adapter.controller.CursoMapper;
import ar.edu.undec.adapter.crud.IBuscarCursoCRUD;
import ar.edu.undec.adapter.entity.CursoEntity;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.output.IBuscarCursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Repository //Marca la clase como repositorio para que Spring la gestione
public class BuscarCursoRepositorioImpl implements IBuscarCursoRepositorio {

    //Inyección de dependencia del CRUD (interfaz que maneja operaciones con la BD)
    @Autowired
    IBuscarCursoCRUD iBuscarCursoCRUD;

    //Constructor para inyección manual
    public BuscarCursoRepositorioImpl(IBuscarCursoCRUD iBuscarCursoCRUD) {
        this.iBuscarCursoCRUD = iBuscarCursoCRUD;
    }

    //Obtiene todos los cursos de la base de datos
    @Override
    public Collection<Curso> buscarTodos() {
        Collection<CursoEntity> cursoEntities = iBuscarCursoCRUD.findAll();
        return CursoMapper.convertirAColeccionDeModelo(cursoEntities);
    }

    //Busca un curso por su nombre
    @Override
    public Curso buscarPorNombre(String nombre) {
        CursoEntity cursoEntity = iBuscarCursoCRUD.findByNombre(nombre);
        //Si no existe el curso, retornamos null
        if (cursoEntity == null) {
            return null;
        }
        return CursoMapper.convertirAModelo(cursoEntity);
    }

    //Busca cursos por fecha de cierre de inscripción
    @Override
    public Collection<Curso> buscarPorFecha(LocalDateTime fecha) {
        Collection<CursoEntity> cursosEntities = iBuscarCursoCRUD.findByFechaCierreInscripcionAfter(fecha);

        //Devuelve una lista vacía si no encuentra nada
        if (cursosEntities == null || cursosEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return CursoMapper.convertirAColeccionDeModelo(cursosEntities);
    }

    //Busca cursos por nivel
    @Override
    public Collection<Curso> buscarPorNivel(Nivel nivel) {
        Collection<CursoEntity> cursosEntities = iBuscarCursoCRUD.findByNivel(nivel);
        return CursoMapper.convertirAColeccionDeModelo(cursosEntities);
    }
}
