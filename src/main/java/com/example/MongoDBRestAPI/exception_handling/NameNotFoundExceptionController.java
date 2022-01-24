package com.example.MongoDBRestAPI.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NameNotFoundExceptionController {
    @ExceptionHandler(value = StudentNameCantBeNullException.class)
    public ResponseEntity<Object> exception(StudentNameCantBeNullException exception) {
        return new ResponseEntity<>("Name not found", HttpStatus.NOT_FOUND);
    }
}
