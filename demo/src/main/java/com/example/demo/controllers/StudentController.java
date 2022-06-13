/* */
package com.example.demo.controllers;

/* */
import com.example.demo.models.StudentModel;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/* */
import java.util.ArrayList;
import java.util.Optional;

/* */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<StudentModel> setStudents() {
        return studentService.setStudents();
    }
    
    /* */
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public StudentModel saveStudents(@RequestBody StudentModel student) {
        return this.studentService.saveStudent(student);
    }
    
    /* */
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<StudentModel> obtenerEstudiantePorId(@PathVariable("id") Long id) {
        return this.studentService.obtenerPorId(id);
    }
    
    /*CONSULTAR ESTUDIANTE POR NOMBRE*/
    @GetMapping("/query")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<StudentModel> ObtenerEstudiantePorNombre(@RequestParam("nombre") String nombre) {
        return this.studentService.obtenerPorNombre(nombre);
    }

    /*ELIMINAR ESTUDIANTE CON EL ID */
    @DeleteMapping(path = "/{id}") /*deleteMapping (eliminar) ,path (enviar una variable) */
    @ResponseStatus(HttpStatus.OK) /* retornar un valor*/
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.studentService.eliminarEstudiante(id);
        if (ok) {
            return "Se eliminó el usuario con el id " + id;
        } else {
            return "No se eliminó el usuario con el id " + id;
        }
    }
}
