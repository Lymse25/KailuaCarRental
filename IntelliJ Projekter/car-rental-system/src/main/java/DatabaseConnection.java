package com.lymae;  // Skift pakkenavnet, hvis nødvendigt.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/KailuaCarRental";  // Skift URL, hvis nødvendigt.
    private static final String USER = "root";  // Dit MySQL-brugernavn.
    private static final String PASSWORD = "password";  // Dit MySQL-password.

    public static Connection getConnection() throws SQLException {
        try {
            // Forbind til databasen
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Fejl ved forbindelse til databasen: " + e.getMessage());
            throw e;  // Kaster undtagelsen videre
        }
    }
}