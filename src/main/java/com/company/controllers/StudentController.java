package com.company.controllers;

import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection; // method imported directly

public class StudentController {

    // Initialize the scanner
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps; // to send commands to DB
    private static ResultSet rs; // to get data from DB

    // Add student controller
    public static boolean addStudent() {
        // Prompt the user for data
        System.out.print("Enter the name of the student: ");
        String name = scanner.next();

        System.out.print("Enter the age of the student: ");
        int age = scanner.nextInt();

        try {
            // INSERT INTO students(name, age) VALUES('name', age);
            ps = getConnection().prepareStatement("INSERT INTO students(name, age) VALUES('" + name + "', " + age + ")");

            ps.execute(); // execute the sql command
            return true; // return true if successful
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

    // Get student By Id controller
    public static Student getStudentById() {
        // Prompt the user to enter the id of the student they want
        // to retrieve
        System.out.print("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {

            ps = getConnection().prepareStatement("SELECT * FROM students WHERE id=" + id);
            rs = ps.executeQuery();

            // Define variables to temporarily hold
            // each field in the result set.
            int studentId, age;
            String name;

            // Instantiate the student object to return at the end of the method
            // execution
            Student student = new Student();

            // Loop through the result set and add the necessary
            // values to the student object.
            while (rs.next()) {
                studentId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student.setName(name);
                student.setId(studentId);
                student.setAge(age);
            }

            return student;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addStudentScores () {

        System.out.print("Enter the id of the student: ");
        int id = scanner.nextInt();
        System.out.print("Enter mathematics score: ");
        int mathScore = scanner.nextInt();
        System.out.print("Enter physics score: ");
        int phScore = scanner.nextInt();
        System.out.print("Enter chemistry score: ");
        int chScore = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("INSERT INTO scores(studentid, mathematics, physics, chemistry) VALUES("
                    + id + "," + mathScore + "," + phScore + "," + chScore + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }


    public static boolean deleteStudent () {
        System.out.print("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement( "DELETE FROM students WHERE id=" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }


    public static boolean deleteScore () {
        System.out.print("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement( "DELETE FROM scores WHERE studentid=" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }


}



