public class Opgave5 {
    public static void main(String[] args) {
        String input = "Vinter som";
        findeSom(input);
    }

    public static void findeSom(String text) {
        boolean found = false;
        for (int i = 0; i <= text.length() - 3; i++) {

            String delAfTekst = text.substring(i, i + 3);


            if (delAfTekst.equals("som")) {
                System.out.println("Ordet 'som' er fundet i teksten!");
                found = true;
            }
        }

        // Hvis "som" ikke er fundet, så udskriv besked
        if (!found) {
            System.out.println("Ordet 'som' er ikke fundet i teksten.");
        }
    }
}