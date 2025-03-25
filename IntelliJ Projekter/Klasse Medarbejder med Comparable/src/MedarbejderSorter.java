import java.util.ArrayList; // Import ArrayList
import java.util.Collections; // Import Collections for sortering

public class MedarbejderSorter {
    public static void main(String[] args) {
        ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
        medarbejdere.add(new Medarbejder("Anna", 35000.50));
        medarbejdere.add(new Medarbejder("John", 42000.75));
        medarbejdere.add(new Medarbejder("Maria", 31000.00));

        System.out.println("Før sortering:");
        for (Medarbejder medarbejder : medarbejdere) {
            System.out.println(medarbejder);
        }

        Collections.sort(medarbejdere);

        System.out.println("\nEfter sortering:");
        for (Medarbejder medarbejder : medarbejdere) {
            System.out.println(medarbejder);
        }
    }
}