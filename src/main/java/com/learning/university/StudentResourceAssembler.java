package com.learning.university;

import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Monali L on 1/21/2020
 */

@Component
public class StudentResourceAssembler implements RepresentationModelAssembler<Student, EntityModel<Student>> {

    @Override
    public EntityModel<Student> toModel(Student student) {
        System.out.println("DEBUG: toModel student - " + student);
        return new EntityModel<Student>(student,
                linkTo(methodOn(StudentController.class).one(student.getId())).withSelfRel(),
                linkTo(methodOn(StudentController.class).all()).withRel("student"));
    }
}
