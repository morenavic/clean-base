package ar.edu.undec.adapter.config;

import ar.edu.undec.adapter.crud.IBuscarCursoCRUD;
import ar.edu.undec.adapter.crud.ICrearCursoCRUD;
import curso.input.IBuscarCursoInput;
import curso.input.ICrearCursoInput;
import curso.output.IBuscarCursoRepositorio;
import curso.output.ICrearCursoRepositorio;
import curso.usecase.BuscarCursoUseCase;
import curso.usecase.CrearCursoUseCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.BuscarCursoRepositorioImpl;
import repository.CrearCursoRepositorioImpl;


@Configuration
//Clase que le indica a Spring cómo instanciar manualmente las dependencias (beans) sin tocar el core
public class CursoConfig {

    //Bean que devuelve la implementación del repositorio de creación de cursos
    @Bean
    public ICrearCursoRepositorio iCrearCursoRepositorio(ICrearCursoCRUD iCrearCursoCRUD) {
        return new CrearCursoRepositorioImpl(iCrearCursoCRUD);
    }

    //Bean que devuelve el caso de uso de crear curso
    @Bean
    public ICrearCursoInput iCrearCursoInput(ICrearCursoRepositorio iCrearCursoRepositorio) {
        return new CrearCursoUseCase(iCrearCursoRepositorio);
    }

    //Bean que devuelve la implementación del repositorio para buscar cursos
    @Bean
    public IBuscarCursoRepositorio buscarCursoRepositorio(IBuscarCursoCRUD iBuscarCursoCRUD) {
        return new BuscarCursoRepositorioImpl(iBuscarCursoCRUD);
    }

    //Bean que devuelve el caso de uso de buscar curso
    @Bean
    public IBuscarCursoInput buscarCursoInput(IBuscarCursoRepositorio buscarCursoRepositorio) {
        return new BuscarCursoUseCase(buscarCursoRepositorio);
    }

}
