import java.time.LocalDate;
public class testString
{
    public static void main(String[] args) // Tilføj 'String[] args'
    {
        char a = 't';
        char b = 'e';
        char c = 'k';
        char d = 's';
        char e = 't';
        char f = '7'; // Karakter '7'
        String tekst = "" + a + b + c + d + e + f;

        System.out.println(tekst);

        System.out.println((int) c); // ASCII-værdi for 'k'
        System.out.println((int) f); // ASCII-værdi for '7'

        // Konverter karakteren '7' til et heltal
        System.out.println(Integer.parseInt("" + f)); // Brug Integer i stedet for integer

        String testS = "Der bor en bager";
        System.out.println(testS.charAt(6)); //Udsriver  indeks 6  - bogstavet r
        System.out.println(testS.substring(4,6));

        LocalDate currentDate = LocalDate.now();
        System.out.println("Dags dato" + currentDate);
    }
}