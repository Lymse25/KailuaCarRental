public class Bil
{
    // instansvariabler
    private String registreringsNummer;
    private int aargang;

    /**
     * Konstruktører for objekter af klassen Bil
     */
    public Bil()
    {    }

    public Bil(String r, int a)
    {
        registreringsNummer = r;
        aargang = a;
    }

    public String getRegistreringsNummer()
    {
        return registreringsNummer;
    }

    public int getAargang()
    {
        return aargang;
    }
}
