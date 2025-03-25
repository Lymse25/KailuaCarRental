public class Person {
    private String navn;
    private int alder;

    // Konstruktør
    public Person(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    // Get-metoder
    public String getNavn() {
        return navn;
    }

    public int getAlder() {
        return alder;
    }
}