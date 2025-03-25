public class Bil {
    public String marke;
    public String model;
    public int aargang;

    // Standardkonstruktor
    public Bil() {
        this.marke = "Ukendt";
        this.model = "Ukendt";
        this.aargang = 0;
    }

    // Konstruktor med parametre
    public Bil(String marke, String model, int aargang) {
        this.marke = marke;
        this.model = model;
        this.aargang = aargang;
    }

    // Get-metoder
    public String getMarke() {
        return marke;
    }

    public String getModel() {
        return model;
    }

    public int getAargang() {
        return aargang;
    }
}