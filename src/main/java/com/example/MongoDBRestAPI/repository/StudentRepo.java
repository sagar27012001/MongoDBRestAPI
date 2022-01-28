package com.example.MongoDBRestAPI.repository;

import java.util.Optional;

import com.example.MongoDBRestAPI.model.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentRepo extends MongoRepository<Student, String> {

    @Query("{id :?0}")
    Optional<Student> getStudentByID(String id);
}
