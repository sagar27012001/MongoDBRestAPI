package com.example.MongoDBRestAPI.repository;

import java.util.Optional;

import com.example.MongoDBRestAPI.model.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentRepo extends MongoRepository<Student, Long> {

    @Query("{id :?0}")
    Optional<Student> getStudentByID(long id);

    default String loadStudents(long id) {
        Student std = getStudentByID(id).orElse(new Student());
        if (std.getName() == null) {
            return "Given ID is not present in Database";
        } else {
            return std.toString();
        }
    }
}
