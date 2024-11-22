package com.example.demo.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.rmi.StubNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }
    @ExceptionHandler(StudentIdNotfound.class)
    public ResponseEntity<String> handleIdNotFound(StudentIdNotfound s){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(s.getMessage());
    }

}
