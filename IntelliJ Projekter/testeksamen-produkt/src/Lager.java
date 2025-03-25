import java.util.ArrayList;

public class Lager {

    // Liste til at gemme produkter
    private ArrayList<Produkt> produkter;

    // Konstruktør
    public Lager() {
        produkter = new ArrayList<>();
    }

    // Metode til at tilføje produkter til listen
    public void tilfoej(Produkt produkt) {
        produkter.add(produkt);
    }

    // main-metode for at teste (valgfrit)
    public static void main(String[] args) {
        Lager lager = new Lager();
        Produkt produkt1 = new Produkt("Produkt1", "Kategori1", 100);
        lager.tilfoej(produkt1);
    }
}