
public class Main {
    public static void main(String[] args) {
        Lagerstyring lager = new Lagerstyring(); // Opret Lagerstyring
        Ordre o1 = new Ordre(1, "Pizza", 120);  // Opret en ordre
        Ordre o2 = new Ordre(2, "Cola", 20);    // Opret endnu en ordre

        lager.tilføjOrdre(o1); // Tilføj ordre til lager
        lager.tilføjOrdre(o2); // Tilføj endnu en ordre

        lager.visOrdrer(); // Vis alle ordrer
    }
}