package com.example.MongoDBRestAPI.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentAgeExceptionController {
    @ExceptionHandler(value = StudentAgeException.class)
    public ResponseEntity<Object> exception(StudentAgeException exception) {
        return new ResponseEntity<>("Age not found", HttpStatus.NOT_FOUND);
    }
}
