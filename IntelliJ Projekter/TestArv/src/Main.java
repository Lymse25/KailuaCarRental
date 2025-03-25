public class Main
{
    public static void main (String[] args)
    {
        Husdyr[] husdyrs = new Husdyr[3];

        Kat miver = new Kat("Miver", "mus");

        Hund mimse = new Hund("Mimse", "kødben", "shitzu");
        // Her mangler der et komma mellem "kødben" og "shitzu"

        Kanin peter = new Kanin("peter", "mælkebøtter");
        husdyrs[2] = peter;

        for (int i = 0; i < husdyrs.length; i++)
            System.out.println(husdyrs[i].getNavn()+ ""+husdyr[i].givLyd());
    }
}