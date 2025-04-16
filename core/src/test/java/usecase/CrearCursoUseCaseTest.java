package usecase;

import curso.modelo.Curso;
import curso.output.ICrearCursoRepositorio;
import curso.usecase.CrearCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCursoUseCaseTest {

    @Mock
    ICrearCursoRepositorio iCrearCursoRepositorio;

    @Test
    void crearCurso_CursoNoExiste_CursoCreado(){
        //Arrange
        Curso curso = Curso.instancia("Clean Architecture", LocalDateTime.now().plusDays(5),"Inicial");
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(iCrearCursoRepositorio);

        when(iCrearCursoRepositorio.existe(curso.getNombre())).thenReturn(false);
        when(iCrearCursoRepositorio.guardar(curso)).thenReturn(true);

        // Act
        boolean resultado = crearCursoUseCase.crearCurso(curso);

        // Assert
        Assertions.assertTrue(resultado);
    }

}