package com.example.MongoDBRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.MappingException;
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
import com.example.MongoDBRestAPI.repository.StudentRepo;
import com.example.MongoDBRestAPI.service.impl.SequenceGeneratorService;

@Service
@RestController
public class StudentController {

    @Autowired
    public StudentRepo repo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping(value = "/students")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @GetMapping(value = "/student/{id}")
    public String getStudent(@PathVariable long id) {
        Student std = repo.getStudentByID(id).orElse(new Student());
        if (std.getName() == null) {
            return "Given ID is not present in Database";
        } else {
            return std.toString();
        }
    }

    @PostMapping(value = "/create")
    public String createStudent(@RequestBody Student student) {
        try {
            if (student.getName() == null || student.getName().length() == 0 || student.getName().isEmpty()) {
                throw new Exception("Name can't be null");
            }
            if (student.getAge() == 0) {
                throw new Exception("Age Can't be 0");
            }
            student.setId(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME));
            repo.save(student);
            return "Student created " + student.getName();
        } catch (Exception exp) {
            return exp.getMessage();
        }

    }

    @DeleteMapping(value = "/student/{id}")
    public String delStudnet(@PathVariable long id) {

        Student isExists = repo.getStudentByID(id).orElse(new Student());
        System.out.println(isExists);
        if (isExists.getName() == null) {
            return "Given ID is not present in Database";
        } else {
            repo.deleteById(id);
            return "Deleted Successfully";
        }
    }

    @PutMapping(value = "/update")
    public String upStudent(@RequestBody Student student) {
        try {
            if (student.getName() == null || student.getName().length() == 0 || student.getName().isEmpty()) {
                throw new Exception("Name can't be null");
            }
            if (student.getAge() == 0) {
                throw new Exception("Age Can't be 0");
            }
            repo.save(student);
            return "Updated Succesfully!";
        } catch (Exception exp) {
            return exp.getMessage();
        }
    }
}