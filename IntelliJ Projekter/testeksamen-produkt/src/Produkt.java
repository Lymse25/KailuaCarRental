public class Produkt {
    private String navn;
    private String kategori;
    private double pris;

    // Konstruktør
    public Produkt(String navn, String kategori, double pris) {
        this.navn = navn;
        this.kategori = kategori;
        this.pris = pris;
    }

    // Gettere
    public String getNavn() {
        return navn;
    }

    public String getKategori() {
        return kategori;
    }

    public double getPris() {
        return pris;
    }

    // ToString-metode for at printe produktet på en læsbar måde
    @Override
    public String toString() {
        return navn + " (" + kategori + ") - Pris: " + pris;
    }
}