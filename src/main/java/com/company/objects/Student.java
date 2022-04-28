package com.company.objects;

import java.sql.SQLException;

import static com.company.dbhelper.DbConnection.getConnection;

public class Student {

    // Define the properties of the Student object
    private int id;
    private String name;
    private int age;

    public Student() {
    }

    // Define constructor
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Define getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}