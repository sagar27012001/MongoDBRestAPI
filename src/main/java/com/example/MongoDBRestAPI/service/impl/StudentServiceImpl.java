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

    @Override
    public String getStudent(String id) {
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

    @Override
    public ResponseEntity<Object> createStudent(Student student) {
        if (student.getName() == null || student.getName().length() == 0 || student.getName().isEmpty()) {
            throw new StudentNameCantBeNullException();
        } else if (student.getAge() == 0) {
            throw new StudentAgeException();
        } else {
            repo.save(student);
            return new ResponseEntity<>("Student added succesfully\n" + student.toString(), HttpStatus.OK);
        }
    }

    @Override
    public String delStudent(String id) {

        Student isExists = repo.getStudentByID(id).orElse(new Student());
        if (isExists.getName() == null) {
            return "Given ID is not present in Database";
        } else {
            Student student = repo.getStudentByID(id).orElse(new Student());
            repo.deleteById(id);
            return "Deleted Successfully\n" + student.toString();
        }
    }

    @Override
    public ResponseEntity<Object> upStudent(Student student) {
        if (student.getName() == null || student.getName().length() == 0 || student.getName().isEmpty()) {
            throw new StudentNameCantBeNullException();
        } else if (student.getAge() == 0) {
            throw new StudentAgeException();
        } else if (student.getStudentByID(student.getId()) == null) {
            return new ResponseEntity<>("Given ID is not present in Database", HttpStatus.NOT_FOUND);
        } else {
            repo.save(student);
            return new ResponseEntity<>("Student Updated succesfully\n" + student.toString(), HttpStatus.OK);
        }
    }
}
