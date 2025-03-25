public class Dato // Navnet på klassen altid med stort begyndelsesbogstav; attributter og alm. metoder med lille begyndelsesbogstav
{
    private int datoen; // Heltal - format YYYYMMDD - klassens eneste attribut/data

    static final String[] dag = {"mandag","tirsdag","onsdag","torsdag","fredag","lørdag","søndag"};
    /*
     * Konstruktører -  skaber objekter/instanser af klassen
     * Constructors     hedder det samme som klassen
     *                  har ingen returværdi; altid public
     */
    public Dato() //Default constructor - skaber et tomt objekt
    {}

    public Dato(int enDato) // Alm. constructor m. parameter
    {
        datoen = enDato;    // Parameteren tildeler attributten en værdi
    }

    public Dato(int enDag, int enMaaned, int etAar)
    {
        datoen = etAar * 10000 + enMaaned * 100 + enDag; // fx 20010000+900+11= 20010911
    }

    /*
     * Klassens metoder - aktuelt kun én
     * udgør sammen med konstruktørerne objekternes adfærd
     */
    public int getDatoen()  // int angiver metodens returværdi
    {
        return datoen;      // værdien af attributten datoen (et heltal) returneres
    }

    public int getAar()
    {
        return datoen / 10000;
    }

    public int getMaaned()
    {
        int maaned = 0;
        maaned = datoen / 100;
        maaned = maaned % 100;
        return maaned;
    }

    public int getMaanedShort()
    {
        return (datoen / 100) % 100;
    }

    public int getDag()
    {
        return datoen % 100;
    }

    public int getKvartal()
    {
        return (getMaaned() + 2) / 3;

    }
    public boolean skudAar()
    {
        //returner true for skudår (fx 2024) og false for ikke skudår (fx 2023)
        //på 400 år skal der være 97 skudår, dvs. hver 4. år minus tre, og de tre er år,
        //som kan divideres med 100, men ikke med 400, så fx 1900 er ikke skudår men 2000 er
        int aar = getAar();

        if (aar % 4 != 0)
        {
            return false;
        }
        else
        if (aar % 100 == 0 && aar % 400 != 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean valid()
    {
        // 1. datoer før 1. marts 1700 afvises (Gregoriansk kalender i DK)
        if (datoen < 17000301)
            return false;
        // 2. måned skal være i intervallet 1-12
        if (getMaaned() < 1 || getMaaned() > 12)
            return false;
        // 3. dag skal være i intervallet 1-31 (varianter tjekkes senere)
        if (getDag() < 1 || getDag() > 31)
            return false;
        // 4. april, juni, september og november har kun 30 dage
        if ((getMaaned() == 4 || getMaaned() == 6 || getMaaned() == 9 || getMaaned() == 11) && getDag() > 30)
            return false;
        // 5. februar: skudår max 29 dage; ikke skudår max 28 dage
        if (skudAar() && getMaaned() == 2 && getDag() > 29)
            return false;
        if (!skudAar() && getMaaned() == 2 && getDag() > 28)
            return false;

        return true;
    }
    // precondition: datoen er valid
    public int dagIAar()
    {
        int skudDag = 0;
        if (skudAar())
            skudDag = 1;

        if (getMaaned() == 1)
            return getDag();
        if (getMaaned() == 2)
            return 31 + getDag();
        if (getMaaned() == 3)
            return 59 + getDag() + skudDag;
        if (getMaaned() == 4)
            return 90 + getDag() + skudDag;
        if (getMaaned() == 5)
            return 120 + getDag() + skudDag;
        if (getMaaned() == 6)
            return 151 + getDag() + skudDag;
        if (getMaaned() == 7)
            return 181 + getDag() + skudDag;
        if (getMaaned() == 8)
            return 212 + getDag() + skudDag;
        if (getMaaned() == 9)
            return 243 + getDag() + skudDag;
        if (getMaaned() == 10)
            return 273 + getDag() + skudDag;
        if (getMaaned() == 11)
            return 304 + getDag() + skudDag;
        return 334 + getDag() + skudDag;
    }

    public int dagIAarShort()
    {
        int skudDag = 0;
        if (skudAar() && getMaaned() > 2)
            skudDag = 1;

        int[] sumDage = {0,0,31,59,90,120,151,181,212,243,273,304,334};

        return getDag() + skudDag + sumDage[getMaaned()];

    }

    public int restDageIAar()
    {
        if (skudAar())
            return 366 - dagIAar();
        return 365 - dagIAar();
    }

    public void setDatoPlusEn()
    {
        datoen++;
        while (!valid())
            datoen++;

    }

    public void setDatoMinusEn()
    {
        datoen--;
        while (!valid())
            datoen--;

    }

    public int forskelIDage(Dato enDato)
    {
        int antalDage = 0;

        Dato kopiDato = new Dato();
        kopiDato.datoen = datoen;

        if (kopiDato.datoen < enDato.datoen)
        {
            while(kopiDato.datoen != enDato.datoen)
            {
                kopiDato.setDatoPlusEn();
                antalDage++;
            }
        }
        else
        if (kopiDato.datoen > enDato.datoen)
        {
            while(kopiDato.datoen != enDato.datoen)
            {
                kopiDato.setDatoMinusEn();
                antalDage--;
            }
        }
        return antalDage;
    }
    public int ugeDag()
    {
        Dato udgDato = new Dato();
        udgDato.datoen = 17000301;

        return udgDato.forskelIDage(this) % 7 +1;
    }

    public String ugeDagTekst()
    {
        return dag[ugeDag()-1];
    }
}




















