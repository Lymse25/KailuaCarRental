public class Person
{
    private String navn;
    private String mail;
    private Dato foedselsdag;
    private Bil bil;

    public Person()
    {}

    public Person(String n, String m, Dato f)
    {
        navn = n;
        mail = m;
        foedselsdag = f;
    }

    public String getNavn()
    {
        return navn;
    }

    public String getMail()
    {
        return mail;
    }

    public Dato getFoedselsdag()
    {
        return foedselsdag;
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



