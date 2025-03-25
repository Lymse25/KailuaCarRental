
/**
 * Write a description of class TestFJV here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestFjernvarme {
    public static void main(String[] args) {
        // Opret to forbrugere
        Forbruger peter = new Forbruger("Peter", 67, 1000);
        Forbruger iben = new Forbruger("Iben", 212, 1000);

        // Opret et distrikt
        Distrikt tagensvej = new Distrikt("Tagensvej", 12.5f);

        // Aflæs målere for Peter (med overløb)
        peter.aflaesMaaler(990);  // Forrige aflæsning
        peter.aflaesMaaler(25);   // Ny aflæsning, overløb er sket

        // Aflæs målere for Iben (ingen overløb)
        iben.aflaesMaaler(220);   // Forrige aflæsning
        iben.aflaesMaaler(250);   // Ny aflæsning

        // Tilføj forbrugerne til distriktet
        tagensvej.addForbruger(peter);
        tagensvej.addForbruger(iben);

        // Test af beregning af forbrug
        System.out.println("Peters forbrug: " + peter.beregnForbrug() + " m3");
        System.out.println("Ibens forbrug: " + iben.beregnForbrug() + " m3");

        // Test af afregning for Peter og Iben
        float afregningPeter = tagensvej.afregnForbruger(67);
        if (afregningPeter != -1) {
            System.out.println("Afregning for Peter: " + afregningPeter + " kr.");
        } else {
            System.out.println("Forbruger med målernummer 67 ikke fundet.");
        }

        float afregningIben = tagensvej.afregnForbruger(212);
        if (afregningIben != -1) {
            System.out.println("Afregning for Iben: " + afregningIben + " kr.");
        } else {
            System.out.println("Forbruger med målernummer 212 ikke fundet.");
        }

        // Test af en ikke-eksisterende forbruger
        float afregningUkendt = tagensvej.afregnForbruger(999);
        if (afregningUkendt != -1) {
            System.out.println("Afregning for ukendt forbruger: " + afregningUkendt + " kr.");
        } else {
            System.out.println("Forbruger med målernummer 999 ikke fundet.");
        }
    }
}
