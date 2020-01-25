package com.learning.university.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Monali L on 1/21/2020
 */

@ControllerAdvice
public class StudentNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String studentNotFoundHandler(StudentNotFoundException ex) {
        return ex.getMessage();
    }
}
