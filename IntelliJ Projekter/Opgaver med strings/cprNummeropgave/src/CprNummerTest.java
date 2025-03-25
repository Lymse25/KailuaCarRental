public class CprNummerTest {
    public static void main(String[] args) {
        // Opret CPR-nummer objekt
        CprNr cpr = new CprNr("0502201972");

        // Test metoder
        System.out.println("CPR-nummer: " + cpr.getCprNr());
        System.out.println("Fødselsdag: " + cpr.getDag());
        System.out.println("Fødselsmåned: " + cpr.getMaaned());
        System.out.println("Fødselsår: " + cpr.getAar());
        System.out.println("Er mand: " + cpr.erMand());
        System.out.println("Er valid: " + cpr.erValid());
    }
}