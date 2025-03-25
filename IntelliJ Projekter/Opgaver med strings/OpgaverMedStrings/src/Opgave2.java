public class Opgave2
{
    private static String tekst;

    public static void main(String[] args)
        {
            String tekst = "macbook";
            System.out.println(omvendtTeks(tekst));
        }

        public static String omvendtTeks(String tekst)
        {
            Opgave2.tekst = tekst;
            StringBuilder omvendt = new StringBuilder(tekst);
            return omvendt.reverse().toString();
        }

}
