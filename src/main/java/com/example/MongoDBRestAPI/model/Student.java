package com.example.MongoDBRestAPI.model;

import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "studnet")
public class Student {
    // public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private String id;
    private String name;
    private double age;
    private int grade;

    public Optional<Student> getStudentByID(String id2) {
        return null;
    }
}
