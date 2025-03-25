import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Liste til forme
        ArrayList<Form> forme = new ArrayList<>();

        // Tilføj forskellige forme
        forme.add(new Cirkel(5.0)); // Cirkel med radius 5.0
        forme.add(new Cirkel(7.5)); // Cirkel med radius 7.5
        forme.add(new Rektangel(4.0, 6.0)); // Rektangel med bredde 4.0 og højde 6.0
        forme.add(new Rektangel(3.5, 8.2)); // Rektangel med bredde 3.5 og højde 8.2

        // Udskriv arealer for alle forme
        for (Form form : forme) {
            System.out.println(form.toString());
        }
    }
}