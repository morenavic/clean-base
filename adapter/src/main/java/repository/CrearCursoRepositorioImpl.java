package repository;
import ar.edu.undec.adapter.crud.ICrearCursoCRUD;
import ar.edu.undec.adapter.entity.CursoEntity;
import curso.modelo.Curso;
import curso.output.ICrearCursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class CrearCursoRepositorioImpl implements ICrearCursoRepositorio{

    @Autowired // Inyección de dependencia de una implementación de esa interfaz que permite Spring Boot
    ICrearCursoCRUD iCrearCursoCRUD;

    @Override
    public boolean existe(String nombre) {
        return false;
    }

    @Override
    public boolean guardar(Curso curso) {
        CursoEntity cursoBD = new CursoEntity();
        cursoBD.setNombre(curso.getNombre());
        cursoBD.setFechaCierreInscripcion(curso.getFechaCierreInscripcion());
        cursoBD.setNivel(curso.getNivel());
        // para retornar un boolean devuelvo el ID
        return this.iCrearCursoCRUD.save(cursoBD).getId()!=null;
    }
}
