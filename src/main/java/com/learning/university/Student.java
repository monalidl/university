package com.learning.university;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Monali L on 1/20/2020
 */

@Data
@Entity
class Student {

    private @Id @GeneratedValue Long id;
    private String name;
    private String enrolledSubject;

    Student() {}

    Student(String name, String enrolledSubject) {
        this.name = name;
        this.enrolledSubject = enrolledSubject;
    }
}
