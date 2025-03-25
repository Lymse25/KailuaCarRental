import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.lymae.kailuacarental.Car;
import com.lymae.kailuacarental.CarCategory;

public class DatabaseTest {

    // Metode til at indsætte en bil i databasen
    public static void insertCar(Car car) {
        String url = "jdbc:mysql://localhost:3306/kailuacarental";
        String user = "root"; // Erstat med din bruger
        String password = "Netsnets1010!"; // Erstat med din adgangskode

        String insertQuery = "INSERT INTO cars (reg_number, brand_model, fuel_type, first_reg_year, first_reg_month, odometer, category_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            pstmt.setString(1, car.getRegNumber());
            pstmt.setString(2, car.getBrandModel());
            pstmt.setString(3, car.getFuelType());
            pstmt.setInt(4, car.getFirstRegYear());
            pstmt.setInt(5, car.getFirstRegMonth());
            pstmt.setInt(6, car.getOdometer());
            pstmt.setInt(7, car.getCategory().getCategoryID());
            pstmt.executeUpdate();
            System.out.println("Bil data er indsat korrekt i databasen!");
        } catch (SQLException e) {
            System.err.println("Fejl ved indsættelse i databasen: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            // Test forbindelse til MySQL
            String url = "jdbc:mysql://localhost:3306/kailuacarental";
            String user = "root";
            String password = "Netsnets1010!";
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("Forbindelsen er oprettet!");
            }

            // Opret en testbil og indsæt den i databasen
            CarCategory category = new CarCategory(1, "Luxury");
            Car car = new Car("AB123CD", "Mercedes S-Class", "Gasoline", 2020, 5, 15000, category);
            insertCar(car);

        } catch (SQLException e) {
            System.err.println("Fejl ved forbindelse til MySQL: " + e.getMessage());
        }
    }
}