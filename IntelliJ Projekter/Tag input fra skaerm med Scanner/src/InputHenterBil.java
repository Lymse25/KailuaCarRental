import java.util.Scanner;

public class InputHenterBil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hent input fra brugeren
        System.out.print("Indtast bilens mærke: ");
        String mærke = scanner.nextLine();

        System.out.print("Indtast bilens model: ");
        String model = scanner.nextLine();

        System.out.print("Indtast bilens årgang: ");
        int årgang = scanner.nextInt();

        // Opret Bil-instans
        Bil bil = new Bil(mærke, model, årgang);

        // Vis oplysningerne
        System.out.println("Du har oprettet en bil:");
        System.out.println("Mærke: " + bil.getMærke());
        System.out.println("Model: " + bil.getModel());
        System.out.println("Årgang: " + bil.getÅrgang());
    }
}