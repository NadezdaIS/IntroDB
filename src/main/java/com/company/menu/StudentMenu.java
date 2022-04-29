package com.company.menu;

import com.company.controllers.StudentController;
import com.company.objects.Student;

import java.util.Scanner;

import static com.company.controllers.StudentController.deleteScore;
import static com.company.controllers.StudentController.getStudentById;

public class StudentMenu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a new student");
        System.out.println("2. Get student by id");
        System.out.println("3. Add scores to student");
        System.out.println("4. Delete a student by id");
        System.out.println("5. Delete scores of a student by id");
        System.out.println("6. Change score for a subject of choice");
//        System.out.println("7. Delete both student and scores");


        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option)  {
            case 1:
                System.out.println(StudentController.addStudent() ? "Successfully added new student" : "Student not added");
                break;
            case 2:
                System.out.println(StudentController.getStudentById().getName());
                break;
            case 3:
                System.out.println(StudentController.addStudentScores() ? "Successfully added scores" : "Scores not added");
                break;
            case 4:
                System.out.println(StudentController.deleteStudent() ? "Successfully deleted" : "Not deleted");
                break;
            case 5:
                System.out.println(StudentController.deleteScore() ? "Successfully deleted" : "Not deleted");
                break;
            case 6:
                System.out.println(StudentController.editScore() ? "Successfully updated" : "Not updated");
                break;
//            case 7:
//                System.out.println("Enter student's id:");
//                int id = scanner.nextInt();
//                System.out.println(StudentController.deleteScore(id) ? "Successfully deleted" : "Not deleted");
//                break;
            default:
                System.out.println("Invalid option. Try again");
                menu();
        }


    }

}