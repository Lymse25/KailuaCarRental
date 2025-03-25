import java.util.ArrayList;

// Bibliotek.java
public class Bibliotek {
    private String navn;
    private String adresse;
    private ArrayList<Bog> bogsamling;
    private ArrayList<Eksemplar> eksemplarer;
    private ArrayList<Laaner> laanere;
    private ArrayList<Udlaan> aktiveUdlaan;

    // Constructor
    public Bibliotek(String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
        this.bogsamling = new ArrayList<>();
        this.eksemplarer = new ArrayList<>();
        this.laanere = new ArrayList<>();
        this.aktiveUdlaan = new ArrayList<>();
    }

    // Metoder til at håndtere bøger
    public void tilfoejBog(Bog bog) {
        bogsamling.add(bog);
    }

    public void tilfoejEksemplar(Eksemplar eksemplar) {
        eksemplarer.add(eksemplar);
    }

    public void registrerLaaner(Laaner laaner) {
        laanere.add(laaner);
    }

    public void registrerUdlaan(Udlaan udlaan) {
        aktiveUdlaan.add(udlaan);
    }

    // Getters og setters
    public String getNavn() { return navn; }
    public void setNavn(String navn) { this.navn = navn; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public ArrayList<Bog> getBogsamling() { return bogsamling; }
    public ArrayList<Eksemplar> getEksemplarer() { return eksemplarer; }
    public ArrayList<Laaner> getLaanere() { return laanere; }
    public ArrayList<Udlaan> getAktiveUdlaan() { return aktiveUdlaan; }
}