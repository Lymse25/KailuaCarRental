public class Bil {
    private String mærke;
    private String model;
    private int aargang;
    private double pris;

    // Konstruktor
    public Bil(String mærke, String model, int aargang, double pris) {
        this.mærke = mærke;
        this.model = model;
        this.aargang = aargang;
        this.pris = pris;
    }

    // Get-metoder
    public String getMærke(){
        return mærke;
    }

    public String getModel(){
        return model;
    }

    public int getAargang(){
        return aargang;
    }

    public double getPris(){
        return pris;
    }

    // toString metode for udskrivning af bilinformation
    @Override
    public String toString(){
        return mærke + "\t" + model + "\t" + aargang + "\t" + pris;
    }
}