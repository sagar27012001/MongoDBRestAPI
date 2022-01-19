package com.example.MongoDBRestAPI;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "studnet")
public class Student {
    @Id
    private long id;
    private String name;
    private double age;
    private int grade;

    public Student() {
    }

    public Student(String name, double age, int grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
