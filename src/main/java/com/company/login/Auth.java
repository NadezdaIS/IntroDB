package com.company.login;

import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class Auth {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void addUser() {

        System.out.print("Enter the username: ");
        String name = scanner.next();
        System.out.print("Enter the password: ");
        String password = scanner.next();
        System.out.print("Enter the role (user, admin): ");
        String role = scanner.next();

        if (role.equalsIgnoreCase("user") || (role.equalsIgnoreCase("admin"))) {
            try {

                ps = getConnection().prepareStatement("INSERT INTO users(username, password, role) " +
                        "VALUES('" + name + "', '" + password + "', '" + role + "')");
                ps.execute();
                System.out.println("User added.");
            } catch (SQLException e) {
                System.out.println("Database Error. Username already exists.");

            }
        } else {

            System.out.println("Not a valid role entered. Try again.");
        }


    }

    public static void deleteUser() {
        System.out.print("Enter the id of the user: ");
        int id = scanner.nextInt();
        try {
            ps = getConnection().prepareStatement("DELETE FROM users WHERE id=" + id);
            ps.execute();
            System.out.println("User deleted.");
        } catch (SQLException e) {
            System.out.println("Database Error");

        }
    }

    public static boolean login() {
        System.out.print("Enter the username: ");
        String name = scanner.next();
        System.out.print("Enter the password: ");
        String password = scanner.next();
        try {
            ps = getConnection().prepareStatement("SELECT * FROM users WHERE username='" + name + "'");
            rs = ps.executeQuery();
            String userName, userPass;
            while (rs.next()) {
                userName = rs.getString("username");
                userPass = rs.getString("password");
                if (userName.equals(name) && userPass.equals(password)) {
                    System.out.println("Login successful");
                    return true;
                } else {
                    System.out.println("Username or password is not correct");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database error");
            return false;
        }
        return false;
    }




}

