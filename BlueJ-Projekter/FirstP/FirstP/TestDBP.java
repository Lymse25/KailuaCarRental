
/**
 * Write a description of class TestDBP here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestDBP
{
    public static void main(String[] args)
    
    {
        Dato petersF = new Dato(19521017);
        
        Person peter = new Person("Peter Hansen", "phdk@gmail.com", petersF);
        
        Bil petersBil =  new Bil("HX42311", 2004);
        peter.addBil(petersBil);
        
        System.out.println(peter.getNavn() + "har fødselsdag "+peter.getFoedseldag().getDatoen()); //nested metodekald
        System.out.println(peter.getNavn() + "s mailadresse er  "+peter.getMail());
        System.out.println(peter.getNavn() + "s bil har registeringsnummer "+peter.getBil().getRegistreringsNummer());
    }
}
