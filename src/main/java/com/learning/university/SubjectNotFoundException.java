package com.learning.university;

/**
 * @author Monali L on 1/22/2020
 */
public class SubjectNotFoundException extends RuntimeException {
    SubjectNotFoundException(Long id) {
        super("Student not found for id - " + id);
    }
}
