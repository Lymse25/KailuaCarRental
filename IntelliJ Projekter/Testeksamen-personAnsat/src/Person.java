public class Person {
    public String navn;
    public int alder;
    public String stilling;

    public Person(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
        this.stilling = stilling;
    }

    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

}
