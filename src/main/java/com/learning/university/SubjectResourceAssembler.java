package com.learning.university;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Monali L on 1/22/2020
 */

@Component
public class SubjectResourceAssembler implements RepresentationModelAssembler<Subject, EntityModel<Subject>> {
    @Override
    public EntityModel<Subject> toModel(Subject subject) {
        return new EntityModel<Subject>(subject,
                linkTo(methodOn(SubjectController.class).one(subject.getId())).withSelfRel(),
                linkTo(methodOn(SubjectController.class).all()).withRel("student"));
    }
}
