package ar.edu.undec.adapter.controller;

import ar.edu.undec.adapter.controller.dto.CursoDTO;
import curso.input.IBuscarCursoInput;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class BuscarCursoController {

    //Dependencia para buscar cursos desde el core
    private final IBuscarCursoInput iBuscarCursoInput;

    @Autowired
    //Inyección de dependencias
    public BuscarCursoController(IBuscarCursoInput iBuscarCursoInput) {
        this.iBuscarCursoInput = iBuscarCursoInput;
    }

    //Endpoint para listar todos los cursos: GET /cursos
    @GetMapping
    public ResponseEntity<Collection<CursoDTO>> obtenerCursos() {
        Collection<Curso> cursos = iBuscarCursoInput.buscarTodosLosCursos();
        // Convertimos cada Curso a un CursoDTO para la respuesta
        Collection<CursoDTO> dtos = cursos.stream().
                map(CursoDTO::desdeCurso).
                collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    //Endpoint para buscar un curso por nombre: GET /cursos/nombre/{nombre}
    @GetMapping("nombre/{nombre}")
    public ResponseEntity<CursoDTO> obtenerCursoPorNombre(@PathVariable String nombre) {
        Curso curso = iBuscarCursoInput.buscarCursoPorNombre(nombre);
        //Convertimos el curso encontrado en CursoDTO para la respuesta
        CursoDTO cursoDTO = CursoDTO.desdeCurso(curso);
        return ResponseEntity.ok(cursoDTO);
    }

    //Endpoint para buscar cursos por fecha posterior al cierre de inscripción: GET /cursos/fecha/{fecha}
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<Collection<CursoDTO>> obtenerCursosPorFecha(@PathVariable("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha) {

        Collection<Curso> cursos = iBuscarCursoInput.buscarCursoPorFecha(fecha);
        // Si no hay cursos que coincidan con la fecha, retornamos una lista vacía
        if (cursos.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        // Convertimos cada Curso a un CursoDTO para la respuesta
        Collection<CursoDTO> dtos = cursos.stream().
                map(CursoDTO::desdeCurso).
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
                map(CursoDTO::desdeCurso).
                collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }


}
