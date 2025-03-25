package com.lymae.kailuacarental;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RenterDAO {

    // Indsæt en ny lejer
    public int insertRenter(Renter renter) {
        String query = "INSERT INTO Renter (name, address, zip, city, mobilePhone, phone, email, driverLicenseNumber, driverSince) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, renter.getName());
            pstmt.setString(2, renter.getAddress());
            pstmt.setString(3, renter.getZip());
            pstmt.setString(4, renter.getCity());
            pstmt.setString(5, renter.getMobilePhone());
            pstmt.setString(6, renter.getPhone());
            pstmt.setString(7, renter.getEmail());
            pstmt.setString(8, renter.getDriverLicenseNumber());
            pstmt.setString(9, renter.getDriverSince());

            pstmt.executeUpdate();

            // Hent den genererede ID
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    System.out.println("Lejer tilføjet med ID: " + id);
                    return id;
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved indsættelse af lejer: " + e.getMessage());
        }

        return -1;
    }

    // Hent alle lejere
    public List<Renter> getAllRenters() {
        List<Renter> renters = new ArrayList<>();
        String query = "SELECT * FROM Renter";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Renter renter = new Renter(
                        rs.getInt("renterID"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("zip"),
                        rs.getString("city"),
                        rs.getString("mobilePhone"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("driverLicenseNumber"),
                        rs.getString("driverSince")
                );

                renters.add(renter);
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af alle lejere: " + e.getMessage());
        }

        return renters;
    }

    // Hent lejer efter ID
    public Renter getRenterById(int renterID) {
        String query = "SELECT * FROM Renter WHERE renterID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, renterID);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Renter(
                            rs.getInt("renterID"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("zip"),
                            rs.getString("city"),
                            rs.getString("mobilePhone"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getString("driverLicenseNumber"),
                            rs.getString("driverSince")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af lejer efter ID: " + e.getMessage());
        }

        return null;
    }

    // Hent lejer efter kørekortnummer
    public Renter getRenterByLicenseNumber(String licenseNumber) {
        String query = "SELECT * FROM Renter WHERE driverLicenseNumber = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, licenseNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Renter(
                            rs.getInt("renterID"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("zip"),
                            rs.getString("city"),
                            rs.getString("mobilePhone"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getString("driverLicenseNumber"),
                            rs.getString("driverSince")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af lejer efter kørekortnummer: " + e.getMessage());
        }

        return null;
    }

    // Opdater en lejer
    public boolean updateRenter(Renter renter) {
        String query = "UPDATE Renter SET name = ?, address = ?, zip = ?, city = ?, " +
                "mobilePhone = ?, phone = ?, email = ?, driverLicenseNumber = ?, " +
                "driverSince = ? WHERE renterID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, renter.getName());
            pstmt.setString(2, renter.getAddress());
            pstmt.setString(3, renter.getZip());
            pstmt.setString(4, renter.getCity());
            pstmt.setString(5, renter.getMobilePhone());
            pstmt.setString(6, renter.getPhone());
            pstmt.setString(7, renter.getEmail());
            pstmt.setString(8, renter.getDriverLicenseNumber());
            pstmt.setString(9, renter.getDriverSince());
            pstmt.setInt(10, renter.getRenterID());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Fejl ved opdatering af lejer: " + e.getMessage());
            return false;
        }
    }

    // Slet en lejer
    public boolean deleteRenter(int renterID) {
        String query = "DELETE FROM Renter WHERE renterID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, renterID);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Fejl ved sletning af lejer: " + e.getMessage());
            return false;
        }
    }

    // Søg efter lejere baseret på navn
    public List<Renter> searchRentersByName(String searchTerm) {
        List<Renter> renters = new ArrayList<>();
        String query = "SELECT * FROM Renter WHERE name LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + searchTerm + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Renter renter = new Renter(
                            rs.getInt("renterID"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("zip"),
                            rs.getString("city"),
                            rs.getString("mobilePhone"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getString("driverLicenseNumber"),
                            rs.getString("driverSince")
                    );

                    renters.add(renter);
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved søgning efter lejere: " + e.getMessage());
        }

        return renters;
    }
}