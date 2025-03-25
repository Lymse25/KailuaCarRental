package com.lymae;  // Skift pakkenavnet, hvis nødvendigt.

import java.sql.*;

public class CarRentalSystem {

    public static void createRental(int customerId, int carId, String fromDateTime, String toDateTime, int maxKM, int startKM) {
        String query = "INSERT INTO Rentals (CustomerID, CarID, FromDateTime, ToDateTime, MaxKM, StartKM, RegistrationNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customerId);
            stmt.setInt(2, carId);
            stmt.setString(3, fromDateTime);
            stmt.setString(4, toDateTime);
            stmt.setInt(5, maxKM);
            stmt.setInt(6, startKM);
            stmt.setString(7, "");  // Tilføj den nødvendige registreringsnummer logik.

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("En ny lejeaftale blev oprettet!");
            }
        } catch (SQLException e) {
            System.out.println("Fejl ved oprettelse af lejeaftale: " + e.getMessage());
        }
    }

    public static void getRentals() {
        String query = "SELECT * FROM Rentals";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int rentalID = rs.getInt("RentalID");
                int customerID = rs.getInt("CustomerID");
                int carID = rs.getInt("CarID");
                String fromDateTime = rs.getString("FromDateTime");
                String toDateTime = rs.getString("ToDateTime");
                int maxKM = rs.getInt("MaxKM");
                int startKM = rs.getInt("StartKM");

                System.out.println("RentalID: " + rentalID + ", CustomerID: " + customerID + ", CarID: " + carID
                        + ", From: " + fromDateTime + ", To: " + toDateTime + ", MaxKM: " + maxKM + ", StartKM: " + startKM);
            }
        } catch (SQLException e) {
            System.out.println("Fejl ved hentning af lejeaftaler: " + e.getMessage());
        }
    }

    public static void updateRental(int rentalId, int newMaxKM) {
        String query = "UPDATE Rentals SET MaxKM = ? WHERE RentalID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, newMaxKM);
            stmt.setInt(2, rentalId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Lejeaftale opdateret!");
            }
        } catch (SQLException e) {
            System.out.println("Fejl ved opdatering af lejeaftale: " + e.getMessage());
        }
    }

    public static void deleteRental(int rentalId) {
        String query = "DELETE FROM Rentals WHERE RentalID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, rentalId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Lejeaftale slettet!");
            }
        } catch (SQLException e) {
            System.out.println("Fejl ved sletning af lejeaftale: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test CRUD metoderne her
        createRental(1, 1, "2024-03-01 10:00:00", "2024-03-05 12:00:00", 1500, 50000);
        getRentals();
        updateRental(1, 2000);
        deleteRental(1);
    }
}