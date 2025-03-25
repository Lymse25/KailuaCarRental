import java.util.Scanner;  
/**
 * @author Lymae
 * @version 13. sep 2024
 */

public class SumOfNumbers2
{  
    public static void main(String args[])  
    {  
        int x, y, result;  // Ændre variabelnavn til result i stedet for sum
        Scanner sc = new Scanner(System.in);  
        System.out.print("Skriv første nummer: ");  
        x = sc.nextInt();  
        System.out.print("Kom med et andet: ");  
        y = sc.nextInt();  
        
        // Kald metoden sum med x og y og gem resultatet i 'result'
        result = sum(x, y);  
        System.out.println("Summen er =: " + result);  
    }  
    
    // Metode der beregner summen
    public static int sum(int a, int b)  
    {  
        return a + b;  // Returnér summen direkte
    }  
}









