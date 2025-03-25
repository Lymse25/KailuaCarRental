// Udlaan.java
public class Udlaan {
    private Eksemplar eksemplar;
    private Laaner laaner;
    private Dato udlaansDato;
    private Dato afleveringsDato;
    private boolean erAfleveret;

    public Udlaan(Eksemplar eksemplar, Laaner laaner, Dato udlaansDato) {
        this.eksemplar = eksemplar;
        this.laaner = laaner;
        this.udlaansDato = udlaansDato;
        this.erAfleveret = false;
    }

    public Eksemplar getEksemplar() { return eksemplar; }
    public Laaner getLaaner() { return laaner; }
    public Dato getUdlaansDato() { return udlaansDato; }
    public Dato getAfleveringsDato() { return afleveringsDato; }
    public boolean isErAfleveret() { return erAfleveret; }
}