import java.util.Scanner;

/**
 * @author Lymae
 * @version 02 sep 2024
 */
public class IfElse {
    public static void main(String[] args){

    Scanner scan = new Scanner (System.in); // underligt med system.in
    System.out.println("Enter a grade:");
    
    int n = scan.nextInt();
    System.out.println(n);
    
    if(n>=90 && n <=100){ // i videoen bruger han True and fales??
    System.out.println("A");
    
    } else if (n>=80 && n <90 ){
    System.out.println("B");
    
    }else if (n>=70 && n <80 ){
    System.out.println("C");
    
    }else if (n>=65 && n <70 ){
    System.out.println("D");
    
    }else if (n>=0 && n <65 ){
    System.out.println("F");
    }else {
        System.out.println("The number you have entered is not in the range");
}
}
}