package com.learning.university.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.university.model.Subject;
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
public class Student {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_subjects",
        joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Subject> enrolledSubjects;

    Student() {}

    public Student(String name) {
        this.name = name;
        this.enrolledSubjects = new ArrayList<>();
    }

}
