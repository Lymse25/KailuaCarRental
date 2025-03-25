
/**
 * Write a description of class distrikt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Distrikt {
    private String navn;
    private float prisPrM3;
    private Forbruger[] forbrugere;
    private int antalForbrugere;

    // Default constructor
    public Distrikt() {
        this.navn = "";
        this.prisPrM3 = 0.0f;
        this.forbrugere = new Forbruger[200];  // Maksimalt 200 forbrugere
        this.antalForbrugere = 0;
    }

    // Constructor med parametre
    public Distrikt(String navn, float prisPrM3) {
        this.navn = navn;
        this.prisPrM3 = prisPrM3;
        this.forbrugere = new Forbruger[200];  // Maksimalt 200 forbrugere
        this.antalForbrugere = 0;
    }

    // Metode til at tilføje en forbruger i distriktet
    public void addForbruger(Forbruger forbruger) {
        if (antalForbrugere < 200) {
            forbrugere[antalForbrugere] = forbruger;
            antalForbrugere++;
        } else {
            System.out.println("Der er ikke plads til flere forbrugere i distriktet.");
        }
    }

    // Metode til at beregne afregning for én forbruger baseret på målernummer
    public float afregnForbruger(int maalerNr) {
        for (int i = 0; i < antalForbrugere; i++) {
            if (forbrugere[i].getMaalerNr() == maalerNr) {
                int forbrug = forbrugere[i].beregnForbrug();
                return forbrug * prisPrM3;  // Returner prisen for forbruget
            }
        }
        // Hvis målernummeret ikke findes, returneres -1
        return -1;
    }

  
    public String toString() {
        return "Distrikt: " + navn + ", Pris pr. m3: " + prisPrM3 + 
               ", Antal forbrugere: " + antalForbrugere;
    }

    // Test af klassen Distrikt
    public static void main(String[] args) {
        Distrikt distrikt = new Distrikt("Bydistrikt", 12.5f);  // Distrikt med navn og pris pr m3

        // Opret nogle forbrugere
        Forbruger forbruger1 = new Forbruger("Lymae", 12345, 10000);
        forbruger1.aflaesMaaler(9500);  // Sæt forbrugerens ny aflæsning
        distrikt.addForbruger(forbruger1);

        Forbruger forbruger2 = new Forbruger("John", 67890, 10000);
        forbruger2.aflaesMaaler(8000);
        distrikt.addForbruger(forbruger2);

        // Afregn for en specifik forbruger ved målernummer
        float afregning = distrikt.afregnForbruger(12345);
        if (afregning != -1) {
            System.out.println("Afregning for forbruger 12345: " + afregning + " kr.");
        } else {
            System.out.println("Forbruger med målernummer 12345 ikke fundet.");
        }

        // Prøv at afregne for en ikke-eksisterende forbruger
        float afregning2 = distrikt.afregnForbruger(99999);
        if (afregning2 != -1) {
            System.out.println("Afregning for forbruger 99999: " + afregning2 + " kr.");
        } else {
            System.out.println("Forbruger med målernummer 99999 ikke fundet.");
        }
    }
}
