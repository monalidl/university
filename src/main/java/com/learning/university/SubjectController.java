package com.learning.university;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Monali L on 1/22/2020
 */

@RestController
public class SubjectController {

    private final SubjectRepository subjectRepository;
    private final SubjectResourceAssembler subjectResourceAssembler;

    public SubjectController(SubjectRepository subjectRepository,
                             SubjectResourceAssembler subjectResourceAssembler) {
        this.subjectRepository = subjectRepository;
        this.subjectResourceAssembler = subjectResourceAssembler;
    }

    // GET
    @GetMapping("/subjects")
    CollectionModel<EntityModel<Subject>> all() {
        List<EntityModel<Subject>> subjects = subjectRepository.findAll().stream()
                .map(subjectResourceAssembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(subjects,
                linkTo(methodOn(SubjectController.class).all()).withSelfRel());
    }

    @GetMapping("/subjects/{id}")
    EntityModel one(@PathVariable Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException(id));
        return subjectResourceAssembler.toModel(subject);
    }

    // POST
    @PostMapping("/subjects")
    Subject createStudent(@RequestBody Subject newSubject) {
        return subjectRepository.save(newSubject);
    }

    // PUT
    @PutMapping("/subjects/{id}")
    Subject editSubject(@RequestBody Subject newSubject, @PathVariable Long id) {
        return subjectRepository.findById(id)
                .map(subject -> {
                    subject.setName(newSubject.getName());
                    subject.setEnrolledStudents(newSubject.getEnrolledStudents());
                    return subjectRepository.save(subject);
                })
                .orElseGet(() -> {
                    newSubject.setId(id);
                    return subjectRepository.save(newSubject);
                });
    }

    // DELETE
    @DeleteMapping("/subjects/{id}")
    void deleteSubject(@PathVariable Long id) {
        subjectRepository.deleteById(id);
    }

    // ********** To get/add students for a subject

    // GET
    @GetMapping("/subjects/{id}/students")
    CollectionModel<EntityModel<Student>> getEnrolledStudents(@PathVariable Long id) {
        // TODO: This is really dirty, so clean it up later!

        List<Student> students = subjectRepository.findById(id).get().getEnrolledStudents();
        List<EntityModel<Student>> rslt = new ArrayList<>();

        for (Student student: students) {
            StudentResourceAssembler studentResourceAssembler = new StudentResourceAssembler();
            rslt.add(studentResourceAssembler.toModel(student));
        }

        return new CollectionModel<>(rslt,
                linkTo(methodOn(StudentController.class).all()).withSelfRel());
    }

    // PUT
    @PutMapping("/subjects/{id}/students/enroll")
    Subject enrollStudent(@RequestBody Student student, @PathVariable Long id) {
        List<Student> studentSet = new ArrayList<>();
        studentSet.add(student);

        return subjectRepository.findById(id)
                .map(subject -> {
                    subject.setEnrolledStudents(studentSet);
                    return subjectRepository.save(subject);
                })
                .orElseThrow(() -> new SubjectNotFoundException(id));
    }

}
