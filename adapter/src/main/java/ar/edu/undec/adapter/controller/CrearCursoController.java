package ar.edu.undec.adapter.controller;

import ar.edu.undec.adapter.controller.dto.CursoDTO;
import curso.input.ICrearCursoInput;
import curso.modelo.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Indica que la clase va a manejar peticiones HTTP y devolver respuestas JSON
@RequestMapping("/cursos") //Define la ruta base para todos los endpoints de este controlador
public class CrearCursoController {

    //Dependencias para crear y buscar cursos desde el core
    private final ICrearCursoInput iCrearCursoInput;

    @Autowired
    //Inyección de dependencias
    public CrearCursoController(ICrearCursoInput iCrearCursoInput){
        this.iCrearCursoInput = iCrearCursoInput;
    }

    //Endpoint para crear un curso: POST /cursos
    @PostMapping
    public ResponseEntity<String> crearCursoDTO(@RequestBody CursoDTO cursoDTO){
        //Convertimos el DTO directamente al modelo del core (Curso)
        Curso curso = CursoDTO.aCurso(cursoDTO);
        //Llamamos al caso de uso
        boolean cursoCreado = iCrearCursoInput.crearCurso(curso);

        //Retorno un HttpStatus.CONFLICT si al crearse el curso se retorna un false.
        if(!cursoCreado){
            ResponseEntity.status(HttpStatus.CONFLICT).body("No se pudo crear el curso.");
        }

        return ResponseEntity.ok("Curso creado correctamente.");
    }

}
