import java.util.ArrayList;

public class Lagerstyring {
    private ArrayList<Ordre> ordre; // Liste til at holde ordrer

    // Standardkonstruktor, initialiserer listen
    public Lagerstyring() {
        this.ordre = new ArrayList<>();
    }

    // Konstruktor med parameter
    public Lagerstyring(ArrayList<Ordre> ordre) {
        this.ordre = ordre;
    }

    // Metode til at tilføje en ordre til listen
    public void tilføjOrdre(Ordre ordre) {
        this.ordre.add(ordre); // Tilføjer ordren til listen
    }

    // Eksempelmetode til at vise alle ordrer (valgfri)
    public void visOrdrer() {
        for (Ordre o : ordre) {
            System.out.println("Ordrenr: " + o.ordrenr + ", Produkt: " + o.produktNavn + ", Pris: " + o.price);
        }
    }
}