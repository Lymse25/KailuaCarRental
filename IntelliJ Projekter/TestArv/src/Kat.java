public class Kat extends Husdyr
{
    private int antalMusFanget;

    public Kat(){}

    public Kat(String navn, String livret)
    {
        super(navn, livret);
        antalMusFanget = 0;
    }

    public void musFanget()
    {
        antalMusFanget++;
    }

    public int getAntalMusFanget()
    {
        return antalMusFanget;
    }

    public String givLyd()
    {
        return "miav";
        // Her mangler der et semikolon efter "miav"
    }
}