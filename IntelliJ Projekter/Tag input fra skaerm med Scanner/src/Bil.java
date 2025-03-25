// Bil-klasse
class Bil {
    private String mærke;
    private String model;
    private int årgang;

    // Konstruktor
    public Bil(String mærke, String model, int årgang) {
        this.mærke = mærke;
        this.model = model;
        this.årgang = årgang;
    }

    // Get-metoder
    public String getMærke() {
        return mærke;
    }

    public String getModel() {
        return model;
    }

    public int getÅrgang() {
        return årgang;
    }
}