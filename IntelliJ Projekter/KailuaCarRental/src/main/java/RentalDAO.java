package com.lymae.kailuacarental;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RentalDAO {

    private CarDAO carDAO = new CarDAO();
    private RenterDAO renterDAO = new RenterDAO();

    // Indsæt en ny udlejning
    public int insertRental(Rental rental) {
        String query = "INSERT INTO Rental (renterID, regNumber, fromDateTime, toDateTime, maxKm, startKm) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, rental.getRenter().getRenterID());
            pstmt.setString(2, rental.getCar().getRegNumber());
            pstmt.setTimestamp(3, Timestamp.valueOf(rental.getFromDateTime()));
            pstmt.setTimestamp(4, Timestamp.valueOf(rental.getToDateTime()));
            pstmt.setInt(5, rental.getMaxKm());
            pstmt.setInt(6, rental.getStartKm());

            pstmt.executeUpdate();

            // Hent den genererede ID
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    System.out.println("Udlejning tilføjet med ID: " + id);
                    return id;
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved indsættelse af udlejning: " + e.getMessage());
        }

        return -1;
    }

    // Hent alle udlejninger
    public List<Rental> getAllRentals() {
        List<Rental> rentals = new ArrayList<>();
        String query = "SELECT * FROM Rental";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int rentalID = rs.getInt("rentalID");
                int renterID = rs.getInt("renterID");
                String regNumber = rs.getString("regNumber");
                LocalDateTime fromDateTime = rs.getTimestamp("fromDateTime").toLocalDateTime();
                LocalDateTime toDateTime = rs.getTimestamp("toDateTime").toLocalDateTime();
                int maxKm = rs.getInt("maxKm");
                int startKm = rs.getInt("startKm");

                // Hent relateret lejer og bil
                Renter renter = renterDAO.getRenterById(renterID);
                Car car = carDAO.getCarByRegNumber(regNumber);

                if (renter != null && car != null) {
                    Rental rental = new Rental(rentalID, renter, car, fromDateTime, toDateTime, maxKm, startKm);
                    rentals.add(rental);
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af alle udlejninger: " + e.getMessage());
        }

        return rentals;
    }

    // Hent udlejning efter ID
    public Rental getRentalById(int rentalID) {
        String query = "SELECT * FROM Rental WHERE rentalID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, rentalID);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int renterID = rs.getInt("renterID");
                    String regNumber = rs.getString("regNumber");
                    LocalDateTime fromDateTime = rs.getTimestamp("fromDateTime").toLocalDateTime();
                    LocalDateTime toDateTime = rs.getTimestamp("toDateTime").toLocalDateTime();
                    int maxKm = rs.getInt("maxKm");
                    int startKm = rs.getInt("startKm");

                    // Hent relateret lejer og bil
                    Renter renter = renterDAO.getRenterById(renterID);
                    Car car = carDAO.getCarByRegNumber(regNumber);

                    if (renter != null && car != null) {
                        return new Rental(rentalID, renter, car, fromDateTime, toDateTime, maxKm, startKm);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af udlejning efter ID: " + e.getMessage());
        }

        return null;
    }

    // Hent udlejninger efter lejerID
    public List<Rental> getRentalsByRenterId(int renterID) {
        List<Rental> rentals = new ArrayList<>();
        String query = "SELECT * FROM Rental WHERE renterID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, renterID);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int rentalID = rs.getInt("rentalID");
                    String regNumber = rs.getString("regNumber");
                    LocalDateTime fromDateTime = rs.getTimestamp("fromDateTime").toLocalDateTime();
                    LocalDateTime toDateTime = rs.getTimestamp("toDateTime").toLocalDateTime();
                    int maxKm = rs.getInt("maxKm");
                    int startKm = rs.getInt("startKm");

                    // Hent relateret lejer og bil
                    Renter renter = renterDAO.getRenterById(renterID);
                    Car car = carDAO.getCarByRegNumber(regNumber);

                    if (renter != null && car != null) {
                        Rental rental = new Rental(rentalID, renter, car, fromDateTime, toDateTime, maxKm, startKm);
                        rentals.add(rental);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af udlejninger efter lejerID: " + e.getMessage());
        }

        return rentals;
    }

    // Hent udlejninger efter bil (registreringsnummer)
    public List<Rental> getRentalsByCarRegNumber(String regNumber) {
        List<Rental> rentals = new ArrayList<>();
        String query = "SELECT * FROM Rental WHERE regNumber = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, regNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int rentalID = rs.getInt("rentalID");
                    int renterID = rs.getInt("renterID");
                    LocalDateTime fromDateTime = rs.getTimestamp("fromDateTime").toLocalDateTime();
                    LocalDateTime toDateTime = rs.getTimestamp("toDateTime").toLocalDateTime();
                    int maxKm = rs.getInt("maxKm");
                    int startKm = rs.getInt("startKm");

                    // Hent relateret lejer og bil
                    Renter renter = renterDAO.getRenterById(renterID);
                    Car car = carDAO.getCarByRegNumber(regNumber);

                    if (renter != null && car != null) {
                        Rental rental = new Rental(rentalID, renter, car, fromDateTime, toDateTime, maxKm, startKm);
                        rentals.add(rental);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af udlejninger efter registreringsnummer: " + e.getMessage());
        }

        return rentals;
    }

    // Opdater en udlejning
    public boolean updateRental(Rental rental) {
        String query = "UPDATE Rental SET renterID = ?, regNumber = ?, fromDateTime = ?, " +
                "toDateTime = ?, maxKm = ?, startKm = ? WHERE rentalID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, rental.getRenter().getRenterID());
            pstmt.setString(2, rental.getCar().getRegNumber());
            pstmt.setTimestamp(3, Timestamp.valueOf(rental.getFromDateTime()));
            pstmt.setTimestamp(4, Timestamp.valueOf(rental.getToDateTime()));
            pstmt.setInt(5, rental.getMaxKm());
            pstmt.setInt(6, rental.getStartKm());
            pstmt.setInt(7, rental.getRentalID());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Fejl ved opdatering af udlejning: " + e.getMessage());
            return false;
        }
    }

    // Slet en udlejning
    public boolean deleteRental(int rentalID) {
        String query = "DELETE FROM Rental WHERE rentalID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, rentalID);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Fejl ved sletning af udlejning: " + e.getMessage());
            return false;
        }
    }

    // Søg efter aktive udlejninger (hvor slutdato er i fremtiden)
    public List<Rental> getActiveRentals() {
        List<Rental> rentals = new ArrayList<>();
        String query = "SELECT * FROM Rental WHERE toDateTime > NOW()";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int rentalID = rs.getInt("rentalID");
                int renterID = rs.getInt("renterID");
                String regNumber = rs.getString("regNumber");
                LocalDateTime fromDateTime = rs.getTimestamp("fromDateTime").toLocalDateTime();
                LocalDateTime toDateTime = rs.getTimestamp("toDateTime").toLocalDateTime();
                int maxKm = rs.getInt("maxKm");
                int startKm = rs.getInt("startKm");

                // Hent relateret lejer og bil
                Renter renter = renterDAO.getRenterById(renterID);
                Car car = carDAO.getCarByRegNumber(regNumber);

                if (renter != null && car != null) {
                    Rental rental = new Rental(rentalID, renter, car, fromDateTime, toDateTime, maxKm, startKm);
                    rentals.add(rental);
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af aktive udlejninger: " + e.getMessage());
        }

        return rentals;
    }
}