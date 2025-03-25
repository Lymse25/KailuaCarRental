import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];

        // Fyld arrayet med tilfældige tal
        for (int i = 0; i < 1000000; i++) {
            array[random.nextInt(10)]++; // Rettet ved at fjerne ekstra ')'
        }

        // Udskriv værdierne i arrayet
        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }
}