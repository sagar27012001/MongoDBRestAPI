package com.example.MongoDBRestAPI.service.impl;

import java.util.List;

import com.example.MongoDBRestAPI.exception_handling.StudentAgeException;
import com.example.MongoDBRestAPI.exception_handling.StudentNameCantBeNullException;
import com.example.MongoDBRestAPI.model.Student;
import com.example.MongoDBRestAPI.repository.StudentRepo;
import com.example.MongoDBRestAPI.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepo repo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public String getStudent(long id) {
        Student std = repo.getStudentByID(id).orElse(new Student());
        if (std.getName() == null) {
            return "Given ID is not present in Database";
        } else {
            return std.toString();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public ResponseEntity<Object> createStudent(Student student) {
        if (student.getName() == null || student.getName().length() == 0 || student.getName().isEmpty()) {
            throw new StudentNameCantBeNullException();
        } else if (student.getAge() == 0) {
            throw new StudentAgeException();
        } else {
            student.setId(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME));
            repo.save(student);
            return new ResponseEntity<>("Student added succesfully", HttpStatus.OK);
        }
    }

    public String delStudent(long id) {

        Student isExists = repo.getStudentByID(id).orElse(new Student());
        System.out.println(isExists);
        if (isExists.getName() == null) {
            return "Given ID is not present in Database";
        } else {
            repo.deleteById(id);
            return "Deleted Successfully";
        }
    }

    public ResponseEntity<Object> upStudent(Student student) {
        if (student.getName() == null || student.getName().length() == 0 || student.getName().isEmpty()) {
            throw new StudentNameCantBeNullException();
        } else if (student.getAge() == 0) {
            throw new StudentAgeException();
        } else {
            repo.save(student);
            return new ResponseEntity<>("Student Updated succesfully", HttpStatus.OK);
        }
    }
}
