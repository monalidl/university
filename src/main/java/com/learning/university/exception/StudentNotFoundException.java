package com.learning.university.exception;

/**
 * @author Monali L on 1/20/2020
 */
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("Student not found for id - " + id);
    }
}
