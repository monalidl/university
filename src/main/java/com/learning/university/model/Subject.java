package com.learning.university.model;

import com.learning.university.model.Student;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Monali L on 1/20/2020
 */

@Data
@Entity
public class Subject {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private String professor;

    @ManyToMany(mappedBy = "enrolledSubjects")
    private List<Student> enrolledStudents;

    Subject() {}

    public Subject(String name, String professor) {
        this.name = name;
        this.professor = professor;
        this.enrolledStudents = new ArrayList<>();
    }
}
