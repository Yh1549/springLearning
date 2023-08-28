package com.learning.springREST.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Global Exception handler
@ControllerAdvice
public class StudentRESTExceptionHandler {
    // add exception handling code
    //add exception handler using @exceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorRes> handleException(StudentNotFoundException exc){
        //create a StudentErrRes
        StudentErrorRes err = new StudentErrorRes();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    //add another exception handler ..catch all
    @ExceptionHandler
    public ResponseEntity<StudentErrorRes> handleException(Exception exc){
        //create a StudentErrRes
        StudentErrorRes err = new StudentErrorRes();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
