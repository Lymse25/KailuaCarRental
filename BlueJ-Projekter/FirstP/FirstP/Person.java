
/**
 * @Lymae
 * @10 sep 2024
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String navn;
    private String mail;
    private Dato foedseldag;
    private Bil bil;
    
    
    public Person()
    {}

    public Person (String n, String m, Dato f) //konstruktor, der er ingen bil
    {
        navn = n;
        mail = m;
        foedseldag = f;
    }
    
    public String getNavn()
    {
        return navn;
    }

    
    public String getMail()
    {
        return mail;
    }

    
    public Dato getFoedseldag()
    {
        return foedseldag;
    }

    
    public Bil getBil()
    {
        return bil;
    }

    public void addBil(Bil b)
    {
        bil = b;
    }















}
