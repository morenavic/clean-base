package repository;
import ar.edu.undec.adapter.crud.ICrearCursoCRUD;
import ar.edu.undec.adapter.entity.CursoEntity;
import curso.modelo.Curso;
import curso.output.ICrearCursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //Marca la clase como repositorio para que Spring la gestione
public class CrearCursoRepositorioImpl implements ICrearCursoRepositorio{

    //Inyección de dependencia del CRUD (interfaz que maneja operaciones con la BD)
    @Autowired
    ICrearCursoCRUD iCrearCursoCRUD;

    //Constructor para inyección manual
    public CrearCursoRepositorioImpl(ICrearCursoCRUD iCrearCursoCRUD) {
        this.iCrearCursoCRUD = iCrearCursoCRUD;
    }

    //Verifica si ya existe un curso con ese nombre en la BD
    @Override
    public boolean existe(String nombre) {
        return iCrearCursoCRUD.existsByNombre(nombre);
    }

    //Guarda un curso en la BD y devuelve true si se guardó correctamente
    @Override
    public boolean guardar(Curso curso) {
        CursoEntity cursoBD = convertirModeloAEntidad(curso);
        //Para retornar un boolean devuelvo el ID
        return this.iCrearCursoCRUD.save(cursoBD).getId()!=null;
    }

    //Metodo privado que convierte un objeto de tipo Curso (modelo) a CursoEntity (entidad)
    private CursoEntity convertirModeloAEntidad(Curso curso){
        CursoEntity cursoEntity = new CursoEntity();
        cursoEntity.setNombre(curso.getNombre());
        cursoEntity.setFechaCierreInscripcion(curso.getFechaCierreInscripcion());
        cursoEntity.setNivel(curso.getNivel());
        return cursoEntity;
    }
}
