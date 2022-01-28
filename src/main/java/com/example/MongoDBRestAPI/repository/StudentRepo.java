package com.example.MongoDBRestAPI.repository;

import java.util.Optional;

import com.example.MongoDBRestAPI.model.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentRepo extends MongoRepository<Student, String> {

    @Query("{id :?0}")
    Optional<Student> getStudentByID(String id);

    default String loadStudents(String id) {
        Student std = getStudentByID(id).orElse(new Student());
        if (std.getName() == null) {
            return "Given ID is not present in Database";
        } else {
            return std.toString();
        }
    }
}
