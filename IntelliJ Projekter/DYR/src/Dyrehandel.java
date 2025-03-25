import java.util.ArrayList;

public class Dyrehandel {
    ArrayList<Dyr> lager = new ArrayList<>();

    public void tilfoejDyr(Dyr dyr) {
        lager.add(dyr);
    }

    public void findDyrUnderPris(double maxPris) {
        for (Dyr dyr : lager) {
            if (dyr.getPris() < maxPris) { // Brug getter
                System.out.println(dyr);
            }
        }
    }

    public static void main(String[] args) {
        Dyrehandel dyrehandel = new Dyrehandel();

        // Tilføj dyr til lageret
        dyrehandel.tilfoejDyr(new Dyr("Bella", "Hund", 2, 1200));
        dyrehandel.tilfoejDyr(new Dyr("Misser", "Kat", 3, 800));
        dyrehandel.tilfoejDyr(new Dyr("Tweety", "Fugl", 1, 400));
        dyrehandel.tilfoejDyr(new Dyr("Max", "Hund", 4, 1500));
        dyrehandel.tilfoejDyr(new Dyr("Pusser", "Kat", 5, 900));

        // Find dyr under 1000 kr
        System.out.println("Dyr under 1000 kr:");
        dyrehandel.findDyrUnderPris(1000);

        // Udskriv samlet antal dyr på lager
        System.out.println("\nSamlet antal dyr på lager: " + dyrehandel.lager.size());
    }
}