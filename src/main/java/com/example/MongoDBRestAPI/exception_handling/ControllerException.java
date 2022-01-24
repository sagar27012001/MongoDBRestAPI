package com.example.MongoDBRestAPI.exception_handling;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ControllerException  extends RuntimeException{
    private String errorCode;
    private String errorMessage;
}

