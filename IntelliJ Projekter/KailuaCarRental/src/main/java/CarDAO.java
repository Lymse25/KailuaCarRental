package com.lymae.kailuacarental;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    // Indsæt en ny bil
    public void insertCar(Car car) {
        String query = "INSERT INTO Car (regNumber, brandModel, fuelType, firstRegYear, firstRegMonth, odometer, categoryID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, car.getRegNumber());
            pstmt.setString(2, car.getBrandModel());
            pstmt.setString(3, car.getFuelType());
            pstmt.setInt(4, car.getFirstRegYear());
            pstmt.setInt(5, car.getFirstRegMonth());
            pstmt.setInt(6, car.getOdometer());
            pstmt.setInt(7, car.getCategory().getCategoryID());

            pstmt.executeUpdate();
            System.out.println("Bil med registreringsnummer " + car.getRegNumber() + " er tilføjet.");

        } catch (SQLException e) {
            System.err.println("Fejl ved indsættelse af bil: " + e.getMessage());
        }
    }

    // Hent alle biler
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT c.*, cc.categoryName FROM Car c " +
                "JOIN CarCategory cc ON c.categoryID = cc.categoryID";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                CarCategory category = new CarCategory(
                        rs.getInt("categoryID"),
                        rs.getString("categoryName")
                );

                Car car = new Car(
                        rs.getString("regNumber"),
                        rs.getString("brandModel"),
                        rs.getString("fuelType"),
                        rs.getInt("firstRegYear"),
                        rs.getInt("firstRegMonth"),
                        rs.getInt("odometer"),
                        category
                );

                cars.add(car);
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af alle biler: " + e.getMessage());
        }

        return cars;
    }

    // Hent bil efter registreringsnummer
    public Car getCarByRegNumber(String regNumber) {
        String query = "SELECT c.*, cc.categoryName FROM Car c " +
                "JOIN CarCategory cc ON c.categoryID = cc.categoryID " +
                "WHERE c.regNumber = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, regNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    CarCategory category = new CarCategory(
                            rs.getInt("categoryID"),
                            rs.getString("categoryName")
                    );

                    return new Car(
                            rs.getString("regNumber"),
                            rs.getString("brandModel"),
                            rs.getString("fuelType"),
                            rs.getInt("firstRegYear"),
                            rs.getInt("firstRegMonth"),
                            rs.getInt("odometer"),
                            category
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af bil efter registreringsnummer: " + e.getMessage());
        }

        return null;
    }

    // Hent biler efter kategori
    public List<Car> getCarsByCategory(int categoryID) {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT c.*, cc.categoryName FROM Car c " +
                "JOIN CarCategory cc ON c.categoryID = cc.categoryID " +
                "WHERE c.categoryID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, categoryID);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CarCategory category = new CarCategory(
                            rs.getInt("categoryID"),
                            rs.getString("categoryName")
                    );

                    Car car = new Car(
                            rs.getString("regNumber"),
                            rs.getString("brandModel"),
                            rs.getString("fuelType"),
                            rs.getInt("firstRegYear"),
                            rs.getInt("firstRegMonth"),
                            rs.getInt("odometer"),
                            category
                    );

                    cars.add(car);
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af biler efter kategori: " + e.getMessage());
        }

        return cars;
    }

    // Opdater en bil
    public boolean updateCar(Car car) {
        String query = "UPDATE Car SET brandModel = ?, fuelType = ?, firstRegYear = ?, " +
                "firstRegMonth = ?, odometer = ?, categoryID = ? WHERE regNumber = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, car.getBrandModel());
            pstmt.setString(2, car.getFuelType());
            pstmt.setInt(3, car.getFirstRegYear());
            pstmt.setInt(4, car.getFirstRegMonth());
            pstmt.setInt(5, car.getOdometer());
            pstmt.setInt(6, car.getCategory().getCategoryID());
            pstmt.setString(7, car.getRegNumber());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Fejl ved opdatering af bil: " + e.getMessage());
            return false;
        }
    }

    // Slet en bil
    public boolean deleteCar(String regNumber) {
        String query = "DELETE FROM Car WHERE regNumber = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, regNumber);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Fejl ved sletning af bil: " + e.getMessage());
            return false;
        }
    }

    // Hent alle bilkategorier
    public List<CarCategory> getAllCategories() {
        List<CarCategory> categories = new ArrayList<>();
        String query = "SELECT * FROM CarCategory";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                CarCategory category = new CarCategory(
                        rs.getInt("categoryID"),
                        rs.getString("categoryName")
                );

                categories.add(category);
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af alle kategorier: " + e.getMessage());
        }

        return categories;
    }

    // Hent kategori efter ID
    public CarCategory getCategoryById(int categoryID) {
        String query = "SELECT * FROM CarCategory WHERE categoryID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, categoryID);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new CarCategory(
                            rs.getInt("categoryID"),
                            rs.getString("categoryName")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af kategori efter ID: " + e.getMessage());
        }

        return null;
    }
}