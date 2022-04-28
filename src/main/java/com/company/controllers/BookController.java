package com.company.controllers;

import com.company.books.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class BookController {


    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


    public static boolean addBook() {

        System.out.print("Enter the name of the book: ");
        String name = scanner.nextLine();

        System.out.print("Enter the price of the book: ");
        int price = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("INSERT INTO books(name, price) VALUES('" + name + "', " + price + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }


    public static Book getBookById() {

        System.out.print("Enter the id of the book: ");
        int id = scanner.nextInt();

        try {

            ps = getConnection().prepareStatement("SELECT * FROM books WHERE id=" + id);
            rs = ps.executeQuery();

            int bookId, price;
            String name;

            Book book = new Book();


            while (rs.next()) {
                bookId = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                book.setName(name);
                book.setId(bookId);
                book.setPrice(price);
            }

            return book;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static boolean deleteBook () {
        System.out.print("Enter the id of the book: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement( "DELETE FROM books WHERE id=" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

    public static boolean editBookName() {
        System.out.print("Enter the id of the book: ");
        int id = scanner.nextInt();
        System.out.print("Enter the new name of the book: ");
        String newName = scanner.next();
        try {
            ps = getConnection().prepareStatement("UPDATE books SET name ='" + newName + "' WHERE id =" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

}
