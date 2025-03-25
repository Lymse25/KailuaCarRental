import java.util.List;        // Importér List
import java.util.ArrayList;   // Importér ArrayList
import java.util.Collections; // Importér Collections
import java.util.Comparator;  // Importér Comparator

public class SorteringBil {
    public static void main(String[] args) {
        List<Bil> biler = new ArrayList<>(); // Opretter en liste af Bil-objekter
        biler.add(new Bil("Mercedes", 2020));
        biler.add(new Bil("BMW", 2015));
        biler.add(new Bil("Audi", 2018));

        Collections.sort(biler, Comparator.comparingInt(Bil::getArgang));  // Sortér efter årgang
        System.out.println("Sorterede biler:");
        for (Bil bil : biler) {
            System.out.println(bil);
        }
    }
}