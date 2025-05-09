package ar.edu.undec.adapter.config;

import curso.input.IBuscarCursoInput;
import curso.input.ICrearCursoInput;
import curso.output.IBuscarCursoRepositorio;
import curso.output.ICrearCursoRepositorio;
import curso.usecase.BuscarCursoUseCase;
import curso.usecase.CrearCursoUseCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//Clase que le indica a Spring cómo instanciar manualmente las dependencias (beans) sin tocar el core
public class CursoConfig {

    //Bean que devuelve el caso de uso de crear curso
    @Bean
    public ICrearCursoInput iCrearCursoInput(ICrearCursoRepositorio iCrearCursoRepositorio) {
        return new CrearCursoUseCase(iCrearCursoRepositorio);
    }

    //Bean que devuelve el caso de uso de buscar curso
    @Bean
    public IBuscarCursoInput buscarCursoInput(IBuscarCursoRepositorio buscarCursoRepositorio) {
        return new BuscarCursoUseCase(buscarCursoRepositorio);
    }

}
