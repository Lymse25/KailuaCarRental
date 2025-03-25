public class CprNr {
    private String nummeret;

    // Constructor
    public CprNr(String etCprNr) {
        this.nummeret = etCprNr;
    }

    // Getter for CPR-nummeret
    public String getCprNr() {
        return this.nummeret;
    }

    // Setter for CPR-nummeret
    public void setCprNr(String etCprNr) {
        this.nummeret = etCprNr;
    }

    // Returnerer dagen fra CPR-nummeret
    public int getDag() {
        return Integer.parseInt(nummeret.substring(0, 2));
    }

    // Returnerer måneden fra CPR-nummeret
    public int getMaaned() {
        return Integer.parseInt(nummeret.substring(2, 4));
    }

    // Returnerer året fra CPR-nummeret med korrekt århundrede
    public int getAar() {
        int aar = Integer.parseInt(nummeret.substring(4, 6));
        int syvendeCiffer = Character.getNumericValue(nummeret.charAt(6));

        if (syvendeCiffer >= 0 && syvendeCiffer <= 3) {
            return 1900 + aar;
        } else if (syvendeCiffer == 4 || syvendeCiffer == 5) {
            return 1800 + aar;
        } else {
            return 2000 + aar;
        }
    }

    // Returnerer om personen er en mand (ulige sidste ciffer)
    public boolean erMand() {
        int sidsteCiffer = Character.getNumericValue(nummeret.charAt(9));
        return sidsteCiffer % 2 != 0;
    }

    // Returnerer om personen er en kvinde (lige sidste ciffer)
    public boolean erKvinde() {
        return !erMand();
    }

    // Tjekker om CPR-nummeret er gyldigt
    public boolean erValid() {
        if (nummeret.length() != 10 || !nummeret.matches("\\d+")) {
            return false; // Tjekker om CPR-nummeret er 10 cifre og numerisk
        }

        // Modulus-11 check
        int[] vaegte = {4, 3, 2, 7, 6, 5, 4, 3, 2, 1};
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(nummeret.charAt(i)) * vaegte[i];
        }
        return sum % 11 == 0;
    }
}