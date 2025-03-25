public class Main {
    public static void main(String[] args) {
        Terningkast terning = new Terningkast();
        int[] count = new int[6]; // Array til at tælle antallet af hver værdi (1-6)

        // Kast terningen 10 gange
        for (int i = 0; i < 10; i++) {
            int resultat = terning.kastTerning();
            System.out.println("Kast " + (i + 1) + ": " + resultat);
            count[resultat - 1]++; // Increment tælleren for den specifikke værdi
        }

        // Udskriv antallet af hver værdi
        System.out.println("\nResultater:");
        for (int i = 0; i < count.length; i++) {
            System.out.println((i + 1) + " blev slået " + count[i] + " gange.");
        }
    }
}
