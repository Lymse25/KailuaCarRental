import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TestFjernvarme {
    public static void main(String[] args) {
        // Opret et distrikt
        Distrikt tagensvej = new Distrikt("Tagensvej", 12.5f);

        // Generer 20 nye forbrugere med tilfældige navne og målernumre
        tagensvej.genererForbrugere(20);

        // Sorter forbrugerne i alfabetisk rækkefølge ved brug af set-metoden
        tagensvej.sorterForbrugereAlfabetisk();

        // Udskriv de sorterede forbrugere
        System.out.println("Forbrugere sorteret i alfabetisk rækkefølge:");
        for (Forbruger forbruger : tagensvej.getForbrugere()) {
            System.out.println(forbruger.toString());
        }

        // Test af afregning for en tilfældig forbruger
        int testMaalerNr = tagensvej.getForbrugere().get(0).getMaalerNr(); // Vælg det første målernummer fra listen
        float afregning = tagensvej.afregnForbruger(testMaalerNr);
        if (afregning != -1) {
            System.out.println("Afregning for forbruger med målernummer " + testMaalerNr + ": " + afregning + " kr.");
        } else {
            System.out.println("Forbruger med målernummer " + testMaalerNr + " ikke fundet.");
        }

        // Test af en ikke-eksisterende forbruger
        float afregningUkendt = tagensvej.afregnForbruger(999);
        if (afregningUkendt != -1) {
            System.out.println("Afregning for ukendt forbruger: " + afregningUkendt + " kr.");
        } else {
            System.out.println("Forbruger med målernummer 999 ikke fundet.");
        }

        // Tjek fordelingen af drenge- og pigenavne
        tagensvej.tjekNavnefordeling();

        // Tjek for duplikerede navne
        tagensvej.tjekDuplikaterAfNavne();

        // Skriv forbrugere til en fil
        ForbrugerPersistens.skrivForbrugereTilFil(tagensvej.getForbrugere(), "forbrugere.txt");

        // Læs forbrugere fra en fil
        List<Forbruger> indlæsteForbrugere = ForbrugerPersistens.læsForbrugereFraFil("forbrugere.txt");
        System.out.println("Indlæste forbrugere fra fil:");
        for (Forbruger forbruger : indlæsteForbrugere) {
            System.out.println(forbruger);
        }

        // Udskriv forbrugere med målernummer i intervallet 700-799
        tagensvej.udskrivForbrugereIMaalerNrInterval(700, 799);
    }
}