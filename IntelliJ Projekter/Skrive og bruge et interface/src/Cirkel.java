public class Cirkel implements Form {
    private double radius;

    // Constructor
    public Cirkel(double radius) {
        this.radius = radius;
    }

    // Implementering af beregnAreal()
    @Override
    public double beregnAreal() {
        return Math.PI * radius * radius;
    }

    // ToString for bedre output
    @Override
    public String toString() {
        return "Cirkel med radius " + radius + " har arealet: " + beregnAreal();
    }
}