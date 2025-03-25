package com.lymae.kailuacarental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/kailuacarental";
    private static final String USER = "root";
    private static final String PASSWORD = "Netsnets1010!"; // Din adgangskode fra DatabaseTest

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database forbindelse lukket.");
            }
        } catch (SQLException e) {
            System.err.println("Fejl ved lukning af database forbindelse: " + e.getMessage());
        }
    }
}