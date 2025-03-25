import java.util.Random;

public class Terningkast {
    private Random random;

    public Terningkast() {
        random = new Random();
    }

    public int kastTerning() {
        return random.nextInt(6) + 1; // Genererer et tal mellem 1 og 6
    }
}