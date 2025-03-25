import java.io.*;

public class FilHåndtering {

    public static void main(String[] args) {
        String filnavn = "tekst.txt";

        // Gem tekst i fil
        try (FileWriter writer = new FileWriter(filnavn)) {
            writer.write("Hej verden!");
            System.out.println("Tekst gemt i filen: " + filnavn);
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning: " + e.getMessage());
        }

        // Læs tekst fra fil
        try (BufferedReader reader = new BufferedReader(new FileReader(filnavn))) {
            String tekst = reader.readLine();
            System.out.println("Tekst læst fra filen: " + tekst);
        } catch (IOException e) {
            System.out.println("Fejl ved læsning: " + e.getMessage());
        }
    }
}