import java.util.List;    // Importér List
import java.util.ArrayList;  // Importér ArrayList
import java.util.Collections;  // Importér Collections
import java.util.Comparator;  // Importér Comparator

class Produkt {
    String navn;
    String kategori;
    double pris;

    public Produkt(String navn, String kategori, double pris) {
        this.navn = navn;
        this.kategori = kategori;
        this.pris = pris;
    }

    @Override
    public String toString() {
        return navn + " " + kategori + " " + pris;
    }
}