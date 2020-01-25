package com.learning.university.exception;

/**
 * @author Monali L on 1/22/2020
 */
public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException(Long id) {
        super("Student not found for id - " + id);
    }
}
