package com.learning.university;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Monali L on 1/22/2020
 */

@ControllerAdvice
public class SubjectNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SubjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String subjectNotFoundHandler(SubjectNotFoundException ex) {
        return ex.getMessage();
    }

}
