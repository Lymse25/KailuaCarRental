// Laaner.java
public class Laaner {
    private int laanerId;
    private String navn;
    private String adresse;
    private String telefon;
    private String email;

    public Laaner(int laanerId, String navn, String adresse, String telefon, String email) {
        this.laanerId = laanerId;
        this.navn = navn;
        this.adresse = adresse;
        this.telefon = telefon;
        this.email = email;
    }

    public int getLaanerId() { return laanerId; }
    public String getNavn() { return navn; }
    public String getAdresse() { return adresse; }
    public String getTelefon() { return telefon; }
    public String getEmail() { return email; }
}