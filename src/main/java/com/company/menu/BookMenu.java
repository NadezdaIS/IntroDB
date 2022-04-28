package com.company.menu;


import com.company.controllers.BookController;

import java.util.Scanner;

public class BookMenu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a new book");
        System.out.println("2. Get book by id");
        System.out.println("3. Delete book by id");
        System.out.println("4. Edit book's name by id");


        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option)  {
            case 1:
                System.out.println(BookController.addBook() ? "Successfully added new book" : "Book not added");
                break;
            case 2:
                System.out.println(BookController.getBookById().getName());
                break;
            case 3:
                System.out.println(BookController.deleteBook() ? "Successfully deleted book" : "Book not deleted");
                break;
            case 4:
                System.out.println(BookController.editBookName() ? "Successfully edited name" : "Name not edited");
                break;
            default:
                System.out.println("Invalid option. Try again");
                menu();
        }


    }

}