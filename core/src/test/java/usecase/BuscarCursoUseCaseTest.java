package usecase;

import curso.exception.NoExisteCursoException;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.output.IBuscarCursoRepositorio;
import curso.usecase.BuscarCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarCursoUseCaseTest {

    @Mock
    IBuscarCursoRepositorio iBuscarCursoRepositorio;

    @Test
    void buscarCursos_ExistenCursos_ListaDeCursos() {
        //Arrange
        Curso curso1 = Curso.instancia("Java", LocalDateTime.now().plusDays(1), Nivel.INICIAL);
        Curso curso2 = Curso.instancia("Spring Boot", LocalDateTime.now().plusDays(2), Nivel.MEDIO);
        BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(iBuscarCursoRepositorio);

        List<Curso> listaCursoSimulada = Arrays.asList(curso1, curso2);

        when(iBuscarCursoRepositorio.buscarTodos()).thenReturn(listaCursoSimulada);

        //Act
        List<Curso> resultado = buscarCursoUseCase.buscarTodosLosCursos();

        //Assert
        Assertions.assertNotNull(resultado);

        Assertions.assertEquals(2, resultado.size());

        Assertions.assertEquals("Java", resultado.get(0).getNombre());
        Assertions.assertEquals("Spring Boot", resultado.get(1).getNombre());
    }

    @Test
    void buscarCursos_ExistenCursos_BuscarPorNombre() {
        // Arrange
        Curso curso = Curso.instancia("Java", LocalDateTime.now().plusDays(10), Nivel.AVANZADO);
        BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(iBuscarCursoRepositorio);

        when(iBuscarCursoRepositorio.buscarPorNombre("Java")).thenReturn(curso);

        // Act
        Curso resultado = buscarCursoUseCase.buscarCursoPorNombre("Java");

        // Assert
        Assertions.assertNotNull(resultado);

        Assertions.assertEquals("Java", resultado.getNombre());
    }

    @Test
    void buscarCursos_NoExistenCursos_BuscarPorNombre() {
        // Arrange
        Curso curso = Curso.instancia("Java", LocalDateTime.now().plusDays(10), Nivel.AVANZADO);
        BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(iBuscarCursoRepositorio);

        when(iBuscarCursoRepositorio.buscarPorNombre("TypeScript")).thenReturn(null);

        // Act - Assert
        Assertions.assertThrows(NoExisteCursoException.class, ()-> buscarCursoUseCase.buscarCursoPorNombre("TypeScript"));
    }

    @Test
    void buscarCursos_ExistenCursos_BuscarPorFecha() {
        // Arrange
        Curso curso1 = Curso.instancia("Spring Boot", LocalDateTime.now().plusDays(10), Nivel.MEDIO);
        Curso curso2 = Curso.instancia("TypeScript", LocalDateTime.now().plusDays(7), Nivel.AVANZADO);
        BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(iBuscarCursoRepositorio);

        List<Curso> listaCursoSimulada = Arrays.asList(curso1, curso2);

        LocalDateTime fechaBusqueda = LocalDateTime.now().plusDays(6);
        when(iBuscarCursoRepositorio.buscarPorFecha(fechaBusqueda)).thenReturn(listaCursoSimulada);

        // Act
        List<Curso> resultado = buscarCursoUseCase.buscarCursoPorFecha(fechaBusqueda);

        // Assert
        Assertions.assertNotNull(resultado);

        Assertions.assertEquals(2, resultado.size());

        Assertions.assertEquals("Spring Boot", resultado.get(0).getNombre());
        Assertions.assertEquals("TypeScript", resultado.get(1).getNombre());
    }

    @Test
    void buscarCursos_NoExistenCursos_BuscarPorFecha() {
        // Arrange
        Curso curso = Curso.instancia("Spring Boot", LocalDateTime.now().plusDays(10), Nivel.MEDIO);
        BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(iBuscarCursoRepositorio);

        LocalDateTime fechaBusqueda = LocalDateTime.now().plusDays(11);
        when(iBuscarCursoRepositorio.buscarPorFecha(fechaBusqueda)).thenReturn(null);

        // Act - Assert
        Assertions.assertThrows(NoExisteCursoException.class, ()-> buscarCursoUseCase.buscarCursoPorFecha(fechaBusqueda));

    }

    @Test
    void buscarCursos_ExistenCursos_BuscarPorNivel() {
        // Arrange
        Curso curso1 = Curso.instancia("Spring Boot", LocalDateTime.now().plusDays(10), Nivel.MEDIO);
        Curso curso2 = Curso.instancia("Base de Datos", LocalDateTime.now().plusDays(2), Nivel.MEDIO);
        BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(iBuscarCursoRepositorio);

        List<Curso> listaCursoSimulada = Arrays.asList(curso1, curso2);

        Nivel nivelBuscado = Nivel.MEDIO;
        when(iBuscarCursoRepositorio.buscarPorNivel(nivelBuscado)).thenReturn(listaCursoSimulada);

        // Act
        List<Curso> resultado = buscarCursoUseCase.buscarCursoPorNivel(nivelBuscado);

        // Assert
        Assertions.assertNotNull(resultado);

        Assertions.assertEquals(2, resultado.size());

        Assertions.assertEquals("Spring Boot", resultado.get(0).getNombre());
        Assertions.assertEquals("Base de Datos", resultado.get(1).getNombre());
    }

    @Test
    void buscarCursos_NoExistenCursos_BuscarPorNivel() {
        // Arrange
        Curso curso = Curso.instancia("Spring Boot", LocalDateTime.now().plusDays(10), Nivel.MEDIO);
        BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(iBuscarCursoRepositorio);

        Nivel nivelBuscado = Nivel.MEDIO;
        when(iBuscarCursoRepositorio.buscarPorNivel(nivelBuscado)).thenReturn(null);

        // Act - Assert
        Assertions.assertThrows(NoExisteCursoException.class, ()-> buscarCursoUseCase.buscarCursoPorNivel(nivelBuscado));

    }
}
