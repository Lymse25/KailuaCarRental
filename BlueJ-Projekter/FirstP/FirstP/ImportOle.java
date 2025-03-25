import java.util.*;
/**
 * @author Lymae
 * @version 03 sep 2024
 */
public class ImportOle
{
    public static void main (String args [])
    {
        
        Scanner scan = new Scanner(System.in);
        
        int tal;
        tal = scan.nextInt();
        
        
        if (tal < 0)
        {
        System.out.println("Tal skal være større end 0");
        }
        else
        {
        if (tal >7)
        {
            System.out.println("Tallet er større end 7");
        }
        else
        if (tal == 7) // hvis tal er lig med 7 ==
        {
            System.out.println("Tallet er lig med 7");
        }
        else
        {
        System.out.println("Tallet er mindre end 7");
        }
        System.out.println (tal);
    }
    System.out.println(tal);
    
    int x, y, z;
    x = scan.nextInt();
    y = scan.nextInt();
    z = scan.nextInt();
    // x, y og z er forskellige, positive heltal - udskriv det største
    if (x > y){
    if (x > z)
    System.out.println ("x er størst");
    }
    
    if (y > x){
    if (y > z)
    System.out.println ("y er størst");
    }
    
    if (z > x){
    if (z > y)
    System.out.println ("z er størst");
    }
}
}