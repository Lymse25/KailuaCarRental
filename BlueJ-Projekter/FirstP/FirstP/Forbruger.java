
/**
 * @author Lymae
 * @version 13 sep 2024
 */
public class Forbruger {
    private String navn;
    private int maalerNr;
    private int nyAflaesning;
    private int forrigeAflaesning;
    private int maalerMax;

    // Default constructor
    public Forbruger() {
        this.navn = "";
        this.maalerNr = 0;
        this.nyAflaesning = 0;
        this.forrigeAflaesning = 0;
        this.maalerMax = 0;
    }

    // Constructor med parametre
    public Forbruger(String navn, int maalerNr, int maalerMax) {
        this.navn = navn;
        this.maalerNr = maalerNr;
        this.nyAflaesning = 0; // Starter som 0
        this.forrigeAflaesning = 0; // Starter som 0
        this.maalerMax = maalerMax;
    }

    // Access metode til maalerNr
    public int getMaalerNr() {
        return maalerNr;
    }

    // Set-metode til navn
    public void setNavn(String navn) {
        this.navn = navn;
    }

    // Access metode til navn
    public String getNavn() {
        return navn;
    }

    // Aflæs måler-metode
    public void aflaesMaaler(int nyAfl) {
        // Opdater forrige aflæsning før ny aflæsning
        this.forrigeAflaesning = this.nyAflaesning;
        this.nyAflaesning = nyAfl;
    }

    // Beregn forbrug-metode
    public int beregnForbrug() {
        int forbrug;
        if (nyAflaesning >= forrigeAflaesning) {
            // Ingen overløb
            forbrug = nyAflaesning - forrigeAflaesning;
        } else {
            // Overløb er sket
            forbrug = (maalerMax - forrigeAflaesning) + nyAflaesning;
        }
        return forbrug;
    }

    
    public String toString() {
        return "Forbruger: " + navn + ", Målernummer: " + maalerNr + 
               ", Forbrug: " + beregnForbrug() + " kubikmeter varme.";
    }

    // Test af klassen Forbruger
    public static void main(String[] args) {
        Forbruger forbruger = new Forbruger("Lymae", 12345, 10000);
        forbruger.aflaesMaaler(9500);  // Forrige aflæsning er 0, ny aflæsning 9500
        System.out.println(forbruger.toString());
        forbruger.aflaesMaaler(500);   // Overløb, ny aflæsning er 500
        System.out.println(forbruger.toString());
    }
}
