public class Student {
    private String navn;
    private int alder;
    private String studie;

    // Konstruktør
    public Student(String navn, int alder, String studie) {
        this.navn = navn;
        this.alder = alder;
        this.studie = studie;
    }

    // Get-metoder
    public String getNavn() {
        return navn;
    }

    public int getAlder() {
        return alder;
    }

    public String getStudie() {
        return studie;
    }
}