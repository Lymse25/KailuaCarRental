// Subklasse Hund der arver fra Dyr
public class Hund extends Dyr {
    // Overskriver lyd() metoden
    @Override
    public void lyd() {
        System.out.println("Vuf");
    }
}