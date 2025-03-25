public class Main {
    public static void main(String[] args) {
        // Opretter objekter af Hund og Kat
        Dyr minHund = new Hund();  // Hund-objekt
        Dyr minKat = new Kat();    // Kat-objekt

        // Kald lyd() metoden på objekterne
        minHund.lyd();  // Udskriver "Vuf"
        minKat.lyd();   // Udskriver "Miaw"
    }
}