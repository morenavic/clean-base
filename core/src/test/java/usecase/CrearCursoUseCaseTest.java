package usecase;

import curso.exception.CursoExisteException;
import curso.exception.GuardarCursoException;
import curso.modelo.Curso;
import curso.modelo.Nivel;
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
        Curso curso = Curso.instancia("Clean Architecture", LocalDateTime.now().plusDays(5), Nivel.INICIAL);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(iCrearCursoRepositorio);

        when(iCrearCursoRepositorio.existe(curso.getNombre())).thenReturn(false);
        when(iCrearCursoRepositorio.guardar(curso)).thenReturn(true);

        // Act
        boolean resultado = crearCursoUseCase.crearCurso(curso);

        // Assert
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearCurso_CursoExiste_CursoExisteException(){
        //Arrange
        Curso curso = Curso.instancia("Bases de Datos",LocalDateTime.now().plusDays(3),Nivel.MEDIO);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(iCrearCursoRepositorio);
        //Simulo la base de datos
        when(iCrearCursoRepositorio.existe(curso.getNombre())).thenReturn(true);
        //Act - Assert
        Assertions.assertThrows(CursoExisteException.class, () -> crearCursoUseCase.crearCurso(curso));
        //Se podría incluir un assert que valide que el metodo guardar() no se ha llamado
    }

    @Test
    void crearCurso_CursoNoExiste_GuardarCursoException(){
        //Arrange
        Curso curso = Curso.instancia("Bases de Datos",LocalDateTime.now().plusDays(3),Nivel.MEDIO);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(iCrearCursoRepositorio);
        //Simulo la base de datos - el curso no existe pero tampoco puede guardarse
        when(iCrearCursoRepositorio.existe(curso.getNombre())).thenReturn(false);
        when(iCrearCursoRepositorio.guardar(curso)).thenReturn(false);
        //Act - Assert
        Assertions.assertThrows(GuardarCursoException.class,
                ()-> crearCursoUseCase.crearCurso(curso));

    }
}