
/**
 * @author Lymae
 * @version 28. aug 2024
 */
public class Bil
{
    // instance variables
    private String registreringsNummer;
    private int aargang;

    /**
     * Constructor for objects of class Bil
     */
    public Bil()
    { }

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
