package com.example.MongoDBRestAPI.service;

import java.util.List;

import com.example.MongoDBRestAPI.model.Student;

import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<Object> getStudent(String id);

    List<Student> getAllStudents();

    ResponseEntity<Object> createStudent(Student student);

    ResponseEntity<Object> delStudent(String id);

    ResponseEntity<Object> upStudent(Student student);
}
