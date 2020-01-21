package com.learning.university;

/**
 * @author Monali L on 1/20/2020
 */
public class StudentNotFoundException extends RuntimeException {

    StudentNotFoundException(Long id) {
        super("Student not found for id - " + id);
    }
}
