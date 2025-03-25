public class Ansat extends Person{ //extends betyder at den arver fra person
    public double lon;
    public String stilling;

    public Ansat (String navn, int alder, double lon, String stilling) {
        super(navn, alder);
        this.lon = lon;
        this.stilling = stilling;
    }

    public void beskrivelse(){
        System.out.println("Ansat " + navn + " " + alder + " " + stilling);
        System.out.println("Person " + navn + " " + alder + " " + stilling);

    }
}
