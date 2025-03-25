public abstract class Husdyr
{
    protected String navn;
    protected String livret;

    public Husdyr (){}

    public Husdyr (String navn, String livret)
    {
        this.navn = navn;
        this.livret = livret;
    }

    public String getNavn ()
    {
        return navn;
    }

    public String getLivret()
    {
        return livret;
    }

    public String givLyd()
    {
        return livret;
    }
}