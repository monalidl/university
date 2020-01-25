package com.learning.university;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Monali L on 1/25/2020
 */

@Data
@Entity
public class StudentEnrollment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}
