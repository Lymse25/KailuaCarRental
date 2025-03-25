// Forfatter.java
public class Forfatter {
    private String navn;
    private Dato foedselsdato;
    private String nationalitet;

    public Forfatter(String navn, Dato foedselsdato, String nationalitet) {
        this.navn = navn;
        this.foedselsdato = foedselsdato;
        this.nationalitet = nationalitet;
    }

    public String getNavn() { return navn; }
    public Dato getFoedselsdato() { return foedselsdato; }
    public String getNationalitet() { return nationalitet; }
}