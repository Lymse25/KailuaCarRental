public class OpgaverMedStrings {

    // Metode til at tælle og udskrive antallet af forekomster af et bogstav i en tekst
    public static void countLetter(String text, char letter) {
        int count = 0;

        // Gennemgå hver karakter i strengen
        for (int i = 0; i < text.length(); i++)
        {
            // Tjek om karakteren er lig med det angivne bogstav
            if (text.charAt(i) == letter)
            {
                count++;
            }
        }

        // Udskriv resultatet
        System.out.println("Bogstavet '" + letter + "' forekommer " + count + " gange i teksten.");
    }

    public static void main(String[] args) {
        // Eksempel
        String tekst = "aaaaaaaaaaA";
        char bogstav = 'a';


        // Kald metoden
        countLetter(tekst, bogstav);
    }
}
