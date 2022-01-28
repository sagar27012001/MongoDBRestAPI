package com.example.MongoDBRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.MongoDBRestAPI.model.Student;
import com.example.MongoDBRestAPI.service.StudentService;

@Service
@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping(value = "/student/{id}")
    public String getStudent(@PathVariable String id) {
        return service.getStudent(id);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @DeleteMapping(value = "/student/{id}")
    public String delStudent(@PathVariable String id) {
        return service.delStudent(id);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> upStudent(@RequestBody Student student) {
        return service.upStudent(student);
    }
}
