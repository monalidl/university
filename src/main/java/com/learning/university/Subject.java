package com.learning.university;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Monali L on 1/20/2020
 */

@Data
@Entity
class Subject {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private String professor;

    @ManyToMany(mappedBy = "enrolledSubjects")
    private List<Student> enrolledStudents;

    Subject() {}

    Subject(String name, String professor) {
        this.name = name;
        this.professor = professor;
        this.enrolledStudents = new ArrayList<>();
    }
}
