import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersonerFil {

    // Metode der skriver en liste af personer til en fil
    public static void skrivPersonerTilFil(List<Person> personer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("personer.txt"))) {
            for (Person person : personer) {
                writer.write(person.getNavn() + "," + person.getAlder());
                writer.newLine();  // Tilføjer en ny linje
            }
            System.out.println("Personer blev skrevet til fil.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}