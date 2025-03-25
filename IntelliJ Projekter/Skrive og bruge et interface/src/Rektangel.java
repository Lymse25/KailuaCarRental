public class Rektangel implements Form {
    private double bredde;
    private double hoejde;

    // Constructor
    public Rektangel(double bredde, double hoejde) {
        this.bredde = bredde;
        this.hoejde = hoejde;
    }

    // Implementering af beregnAreal()
    @Override
    public double beregnAreal() {
        return bredde * hoejde;
    }

    // ToString for bedre output
    @Override
    public String toString() {
        return "Rektangel med bredde " + bredde + " og højde " + hoejde + " har arealet: " + beregnAreal();
    }
}