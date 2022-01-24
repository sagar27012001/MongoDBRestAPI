package com.example.MongoDBRestAPI.exception_handling;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
}
