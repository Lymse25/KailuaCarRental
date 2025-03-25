import java.util.List;        // Importér List
import java.util.ArrayList;   // Importér ArrayList
import java.util.Collections; // Importér Collections
import java.util.Comparator;  // Importér Comparator
public class SorteringProdukt {
    public static void main(String[] args) {
        List<Produkt> produkter = new ArrayList<>();  // Brug ArrayList til at oprette listen
        produkter.add(new Produkt("Laptop", "Elektronik", 6000));
        produkter.add(new Produkt("Kaffemaskine", "Husholdning", 800));
        produkter.add(new Produkt("Smartphone", "Elektronik", 3000));

        Collections.sort(produkter, Comparator.comparingDouble(produkt -> produkt.pris));  // Sortér efter pris
        System.out.println("Sorterede produkter:");
        for (Produkt produkt : produkter) {
            System.out.println(produkt);
        }
    }
}