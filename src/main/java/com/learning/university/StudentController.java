package com.learning.university;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Monali L on 1/20/2020
 */

@RestController
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentResourceAssembler studentResourceAssembler;

    public StudentController(StudentRepository studentRepository,
                             StudentResourceAssembler studentResourceAssembler1) {
        this.studentRepository = studentRepository;
        this.studentResourceAssembler = studentResourceAssembler1;
    }

    // GET
    @GetMapping("/students")
    CollectionModel<EntityModel<Student>> all() {
        List<EntityModel<Student>> students = studentRepository.findAll().stream()
                .map(studentResourceAssembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(students,
                linkTo(methodOn(StudentController.class).all()).withSelfRel());
    }

    @GetMapping("/students/{id}")
    EntityModel one(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return studentResourceAssembler.toModel(student);
    }

    // POST
    @PostMapping("/students")
    Student createStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    // PUT
    @PutMapping("/students/{id}")
    Student editStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setEnrolledSubject(newStudent.getEnrolledSubject());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    // DELETE
    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
