public class Bil {
    private String model;
    private int argang;

    // Opdater konstruktoren til kun at kræve model og årgang
    public Bil(String model, int argang) {
        this.model = model;
        this.argang = argang;
    }

    // Getter til årgang
    public int getArgang() {
        return argang;
    }

    @Override
    public String toString() {
        return model + " " + argang;
    }
}