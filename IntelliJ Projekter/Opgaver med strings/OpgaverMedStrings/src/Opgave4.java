import java.util.Scanner;

public class Opgave4
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Læs to strenge fra brugeren
        System.out.print("Indtast første tal: ");
        String tal1 = scanner.next();  // Indlæser første tal som en String

        System.out.print("Indtast andet tal: ");
        String tal2 = scanner.next();  // Indlæser andet tal som en String

        // Udskriv de to indtastede strenge
        System.out.println("Første tal: " + tal1);
        System.out.println("Andet tal: " + tal2);

        // Konverter strenge til heltal
        int intTal1 = Integer.parseInt(tal1);  // Konverterer tal1 til et heltal
        int intTal2 = Integer.parseInt(tal2);  // Konverterer tal2 til et heltal

        // Beregn og udskriv summen
        int sum = intTal1 + intTal2;
        System.out.println("Summen af de to tal: " + sum);
    }
}