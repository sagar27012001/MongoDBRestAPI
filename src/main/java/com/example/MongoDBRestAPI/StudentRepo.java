package com.example.MongoDBRestAPI;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentRepo extends MongoRepository<Student, Long> {

    @Query("{id :?0}")
    Optional<Student> getStudentByID(long id);
}
