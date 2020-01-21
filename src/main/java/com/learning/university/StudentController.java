package com.learning.university;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Monali L on 1/20/2020
 */

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // GET
    @GetMapping("/students")
    List<Student> all() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    Student one(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
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
