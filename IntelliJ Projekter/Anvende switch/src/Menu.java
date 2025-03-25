import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        // Scanner til at læse brugerinput
        Scanner scanner = new Scanner(System.in);

        // Beder brugeren om at vælge en mulighed
        System.out.println("Vælg en mulighed (1, 2 eller 3):");
        int valg = scanner.nextInt();  // Læser brugerens valg

        // Brug switch-udtalelse til at vælge mellem mulighederne
        switch (valg) {
            case 1:
                System.out.println("Du har valgt mulighed 1");
                break;
            case 2:
                System.out.println("Du har valgt mulighed 2");
                break;
            case 3:
                System.out.println("Du har valgt mulighed 3");
                break;
            default:
                System.out.println("Ugyldigt valg! Vælg enten 1, 2 eller 3.");
                break;
        }

        // Luk scanner for at undgå ressource lækage
        scanner.close();
    }
}