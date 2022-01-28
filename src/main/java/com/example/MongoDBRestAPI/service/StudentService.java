package com.example.MongoDBRestAPI.service;

import java.util.List;

import com.example.MongoDBRestAPI.model.Student;

import org.springframework.http.ResponseEntity;

public interface StudentService {
    String getStudent(String id);

    List<Student> getAllStudents();

    ResponseEntity<Object> createStudent(Student student);

    String delStudent(String id);

    ResponseEntity<Object> upStudent(Student student);
}
