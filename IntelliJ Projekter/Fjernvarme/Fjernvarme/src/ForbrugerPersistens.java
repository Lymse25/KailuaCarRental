import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ForbrugerPersistens {
    // Metode til at skrive en liste af forbrugere til en .txt-fil
    public static void skrivForbrugereTilFil(List<Forbruger> forbrugere, String filnavn) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filnavn))) {
            for (Forbruger forbruger : forbrugere) {
                // Formatterer forbrugerens data som en linje
                String forbrugerData = forbruger.getNavn() + "," + forbruger.getMaalerNr() + "," +
                        forbruger.beregnForbrug();  // Forbrug som flydende tal

                // Skriver linjen til filen
                writer.write(forbrugerData);
                writer.newLine(); // Tilføjer en ny linje i filen
            }
        } catch (IOException e) {
            e.printStackTrace(); // Fejlhåndtering ved skrivefejl
        }
    }
//Din metode skrivForbrugereTilFil ser rigtig god ud. Den tager en liste af Forbruger objekter og skriver deres data til en fil.
// Den formaterer forbrugerens
// data korrekt og håndterer undtagelser, hvis der opstår fejl under skrivningen.
    // Metode til at læse forbrugere fra en .txt-fil
    public static List<Forbruger> læsForbrugereFraFil(String filnavn) {
        List<Forbruger> forbrugere = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filnavn))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String navn = data[0];
                int maalerNr = Integer.parseInt(data[1]);  // Målernummer som int
                float forbrug = Float.parseFloat(data[2]);  // Forbrug som float

                // Opretter Forbruger-objekt og tilføjer til listen
                Forbruger forbruger = new Forbruger(navn, maalerNr, 0, (int) forbrug);
                forbrugere.add(forbruger);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Fejlhåndtering ved læsefejl
        } catch (NumberFormatException e) {
            System.err.println("Fejl ved konvertering af tal: " + e.getMessage());
        }
        return forbrugere; // Returnerer listen af forbrugere
    }
}