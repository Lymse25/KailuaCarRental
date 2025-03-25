// Eksemplar.java
public class Eksemplar {
    private int eksemplarId;
    private Bog bog;
    private String tilstand;
    private boolean erUdlant;

    public Eksemplar(int eksemplarId, Bog bog, String tilstand) {
        this.eksemplarId = eksemplarId;
        this.bog = bog;
        this.tilstand = tilstand;
        this.erUdlant = false;
    }

    public int getEksemplarId() { return eksemplarId; }
    public Bog getBog() { return bog; }
    public String getTilstand() { return tilstand; }
    public boolean isErUdlant() { return erUdlant; }
    public void setErUdlant(boolean erUdlant) { this.erUdlant = erUdlant; }
}