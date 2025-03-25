import java.util.ArrayList;  // Import ArrayList
import java.util.Collections; // Import Collections for sortering

class Medarbejder implements Comparable<Medarbejder> {
    private String navn;
    private double løn;

    // Konstruktor
    public Medarbejder(String navn, double løn) {
        this.navn = navn;
        this.løn = løn;
    }

    // Get-metoder
    public String getNavn() {
        return navn;
    }

    public double getLøn() {
        return løn;
    }

    // Implementer Comparable
    @Override
    public int compareTo(Medarbejder other) {
        return Double.compare(this.løn, other.løn);
    }

    @Override
    public String toString() {
        return "Medarbejder [Navn=" + navn + ", Løn=" + løn + "]";
    }
}