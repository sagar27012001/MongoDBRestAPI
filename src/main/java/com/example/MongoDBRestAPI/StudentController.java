package com.example.MongoDBRestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    public StudentRepo repo;

    @GetMapping(value = "/students")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @GetMapping(value = "/student/{id}")
    public Optional<Student> getStudent(@PathVariable long id) {
        return repo.findById(id);
    }

    @PostMapping(value = "/create")
    public String createStudent(@RequestBody Student studnet) {
        Student inserted = repo.insert(studnet);
        return "Student created " + inserted.getName();
    }

    @DeleteMapping(value = "/student/{id}")
    public String delStudnet(@PathVariable long id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    @PutMapping(value = "/update")
    public String upStudent(@RequestBody Student student) {
        repo.save(student);
        return "Updated Successfully";
    }
}
