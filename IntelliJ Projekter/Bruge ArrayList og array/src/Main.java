public class Main {
    public static void main(String[] args) {
        NavneListe navneListe = new NavneListe();

        // Tilføj navne
        navneListe.tilfoejNavn("Alice");
        navneListe.tilfoejNavn("Bob");
        navneListe.tilfoejNavn("Charlie");
        navneListe.tilfoejNavn("Diana");
        navneListe.tilfoejNavn("Eve");

        // Fjern et navn
        navneListe.fjernNavn("Charlie");

        // Udskriv den endelige liste
        navneListe.udskrivListe();
    }
}