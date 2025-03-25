public class Dyr {
    private String navn;
    private String art;
    private int alder;
    private double pris;

    public Dyr(String navn, String art, int alder, double pris) {
        this.navn = navn;
        this.art = art;
        this.alder = alder;
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public String getArt() {
        return art;
    }

    public int getAlder() {
        return alder;
    }

    public double getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return navn + " (" + art + "), Alder: " + alder + ", Pris: " + pris + " kr";
    }
}