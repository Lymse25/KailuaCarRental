import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StuderendeFil {

    // Metode der skriver en liste af studerende til en fil
    public static void skrivStuderendeTilFil(List<Student> studerende) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("studenter.txt"))) {
            for (Student student : studerende) {
                writer.write(student.getNavn() + "," + student.getAlder() + "," + student.getStudie());
                writer.newLine();  // Tilføjer en ny linje
            }
            System.out.println("Studerende blev skrevet til fil.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}