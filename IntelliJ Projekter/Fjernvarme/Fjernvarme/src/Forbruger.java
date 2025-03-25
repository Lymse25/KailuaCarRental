public class Forbruger {
    private String navn;
    private int målernummer;
    private int startforbrug;
    private int slutforbrug; // disse er parametere

    public Forbruger(String navn, int målernummer, int startforbrug, int slutforbrug) {
        this.navn = navn;
        this.målernummer = målernummer;
        this.startforbrug = startforbrug;
        this.slutforbrug = slutforbrug;
    }

    public String getNavn() {
        return navn;
    }

    public int getMaalerNr() {
        return målernummer;
    }

    public void opdaterSlutForbrug(int ekstraForbrug) {
        this.slutforbrug = startforbrug + ekstraForbrug;
    }

    public float beregnForbrug() {
        return slutforbrug - startforbrug;
    }

    @Override
    public String toString() {
        return navn + " (Målernummer: " + målernummer + ", Startforbrug: " + startforbrug + ", Slutforbrug: " + slutforbrug + ")";
    }
}