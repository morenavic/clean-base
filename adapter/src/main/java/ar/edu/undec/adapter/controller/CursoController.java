package ar.edu.undec.adapter.controller;

import ar.edu.undec.adapter.controller.dto.CursoDTO;
import curso.input.IBuscarCursoInput;
import curso.input.ICrearCursoInput;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@RestController //Indica que la clase va a manejar peticiones HTTP y devolver respuestas JSON
@RequestMapping("/cursos") //Define la ruta base para todos los endpoints de este controlador
public class CursoController {

    //Dependencias para crear y buscar cursos desde el core
    private final ICrearCursoInput iCrearCursoInput;
    private final IBuscarCursoInput iBuscarCursoInput;

    @Autowired
    //Inyección de dependencias
    public CursoController (ICrearCursoInput iCrearCursoInput, IBuscarCursoInput iBuscarCursoInput){
        this.iCrearCursoInput = iCrearCursoInput;
        this.iBuscarCursoInput = iBuscarCursoInput;
    }

    //Endpoint para crear un curso: POST /cursos
    @PostMapping
    public ResponseEntity<String> crearCursoDTO(@RequestBody CursoDTO cursoDTO){

        //Convertimos el DTO directamente al modelo del core (Curso)
        Curso curso = new Curso(
                cursoDTO.getNombre(),
                cursoDTO.getFechaCierreInscripcion(),
                cursoDTO.getNivel()
        );

        //Llamamos al caso de uso
        boolean cursoCreado = iCrearCursoInput.crearCurso(curso);

        return ResponseEntity.ok("Curso creado correctamente.");
    }

    //Endpoint para listar todos los cursos: GET /cursos
    @GetMapping
    public ResponseEntity<Collection<CursoDTO>> obtenerCursos() {
        Collection<Curso> cursos = iBuscarCursoInput.buscarTodosLosCursos();
        // Convertimos cada Curso a un CursoDTO para la respuesta
        Collection<CursoDTO> dtos = cursos.stream().
                map(this::convertirCursoACursoDTO).
                collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    //Endpoint para buscar un curso por nombre: GET /cursos/nombre/{nombre}
    @GetMapping("nombre/{nombre}")
    public ResponseEntity<CursoDTO> obtenerCursoPorNombre(@PathVariable String nombre) {
        Curso curso = iBuscarCursoInput.buscarCursoPorNombre(nombre);
        //Convertimos el curso encontrado en CursoDTO para la respuesta
        CursoDTO cursoDTO = convertirCursoACursoDTO(curso);
        return ResponseEntity.ok(cursoDTO);
    }

    //Endpoint para buscar cursos por fecha posterior al cierre de inscripción: GET /cursos/fecha/{fecha}
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<Collection<CursoDTO>> obtenerCursosPorFecha(@PathVariable("fecha") String fechaStr) {
        //Convertir la cadena de texto a LocalDataTime
        LocalDateTime fecha = LocalDateTime.parse(fechaStr);
        Collection<Curso> cursos = iBuscarCursoInput.buscarCursoPorFecha(fecha);
        // Si no hay cursos que coincidan con la fecha, retornamos una lista vacía
        if (cursos.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        // Convertimos cada Curso a un CursoDTO para la respuesta
        Collection<CursoDTO> dtos = cursos.stream().
                map(this::convertirCursoACursoDTO).
                collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    //Endpoint para buscar cursos por nivel: GET /cursos/nivel/{nivel}
    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<Collection<CursoDTO>> obtenerCursosPorNivel(@PathVariable("nivel") String nivelStr) {
        //Convertir la cadena de texto a Nivel
        Nivel nivel = Nivel.valueOf(nivelStr.toUpperCase()); //Aseguramos que la cadena esté en mayúsculas
        Collection<Curso> cursos = iBuscarCursoInput.buscarCursoPorNivel(nivel); // Caso de uso que filtra por nivel
        //Convertimos cada Curso a un CursoDTO para la respuesta
        Collection<CursoDTO> dtos = cursos.stream().
                map(this::convertirCursoACursoDTO).
                collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    //Metodo privado para convertir un objeto Curso en un objeto CursoDTO.
    private CursoDTO convertirCursoACursoDTO(Curso curso) {
        return new CursoDTO(
                curso.getNombre(),
                curso.getFechaCierreInscripcion(),
                curso.getNivel()
        );
    }

}
