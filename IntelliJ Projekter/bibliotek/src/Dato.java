// Dato.java
public class Dato {
    private int dag;
    private int maaned;
    private int aar;

    public Dato(int dag, int maaned, int aar) {
        this.dag = dag;
        this.maaned = maaned;
        this.aar = aar;
    }

    public int getDag() { return dag; }
    public int getMaaned() { return maaned; }
    public int getAar() { return aar; }
}
