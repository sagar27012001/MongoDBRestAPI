package com.example.MongoDBRestAPI.service;

import java.util.List;

import com.example.MongoDBRestAPI.model.Student;

import org.springframework.http.ResponseEntity;

public interface StudentService {
    String getStudent(long id);

    List<Student> getAllStudents();

    ResponseEntity<Object> createStudent(Student student);

    String delStudent(long id);

    ResponseEntity<Object> upStudent(Student student);
}
