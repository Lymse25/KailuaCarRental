// Bog.java
public class Bog {
    private String titel;
    private String isbn;
    private Forfatter forfatter;
    private String genre;
    private int udgivelsesaar;

    public Bog(String titel, String isbn, Forfatter forfatter, String genre, int udgivelsesaar) {
        this.titel = titel;
        this.isbn = isbn;
        this.forfatter = forfatter;
        this.genre = genre;
        this.udgivelsesaar = udgivelsesaar;
    }

    public String getTitel() { return titel; }
    public String getIsbn() { return isbn; }
    public Forfatter getForfatter() { return forfatter; }
    public String getGenre() { return genre; }
    public int getUdgivelsesaar() { return udgivelsesaar; }
}