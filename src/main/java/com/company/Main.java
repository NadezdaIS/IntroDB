package com.company;

import com.company.controllers.StudentController;
import com.company.login.Auth;
import com.company.menu.StudentMenu;
import com.company.menu.BookMenu;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

//    List<Book> booksPotter = new ArrayList<>();
//    booksPotter.add (new Book(1, "Philosophers Stone", 15));
//    booksPotter.add (new Book(2, "Chamber of Secrets", 12));
//    booksPotter.add (new Book(3, "Prisoner of Azkaban", 17));
//    booksPotter.add (new Book(4, "Goblet of Fire", 27));
//    booksPotter.add (new Book(5, "Order of the Phoenix", 16));
//
//        for (int i = 0; i < booksPotter.size(); i++) {
//            if (booksPotter.get(i).getPrice() > 5.0)
//            System.out.println(booksPotter.get(i).getName());
//        }

//        DbConnection.getConnection (); // checking connection to database

//        StudentMenu.menu();
        BookMenu.menu();
//        Auth.addUser();
//        Auth.deleteUser();
//        if (Auth.login()){
//            StudentMenu.menu();
//        } else {
//            System.out.println("Invalid login");
//        }




// Option 2 using list called books // method should be called in Main System.out.println(filterLessThanFive(books));
/*        public static List<String> filterLessThanFive(List<Book> books) {


//        an anonymous function - lambda // this part is not used in this method
//        books.removeIf(book -> book.getPrice() < 5);
//        return books;

// Define a list of string for the booknames
            List<String> bookNames = new ArrayList<>();

// Use a loop to filter the books less than 5
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getPrice() < 5) books.remove(books.get(i));
            }

// add each remaining book name to the bookNames list.
            books.forEach(book -> bookNames.add(book.getName()));

// return the list of book names.
            return bookNames;
        }*/

    }





}
