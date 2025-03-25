public class Opgave3

{
      public static void main(String[] args)
        {
          String input = "P. Hansen Danmark";
          udskrivHverAndenBogstav(input);
        }
        public static void udskrivHverAndenBogstav(String text)
      {
       // indsætter ind i en for Loo0 pr = 0 i skal så være mindre en text.length også skal metoden i + med 2
       // det vil så udskrive hver anden bogstav
        for
         (int i = 0; i < text.length(); i += 2)
      
        {
         // Her printer vi sp text men med den integer vi har kaldt i som så er text mindre end i plus 2
        System.out.print(text.charAt(i));
        }
      }
  }