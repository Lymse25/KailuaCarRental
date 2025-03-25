public class MainTal {
    public static void main(String[] args) {
        int[] tal = {5, 10, 3, 15, 8, 22, 4, 7, 13, 1};

        // Beregninger
        int sum = TalArray.findSum(tal);
        double gennemsnit = TalArray.findGennemsnit(tal);
        int stoerste = TalArray.findStoerste(tal);
        int mindste = TalArray.findMindste(tal);

        // Udskriv resultater
        System.out.println("Summen af tallene: " + sum);
        System.out.println("Gennemsnittet af tallene: " + gennemsnit);
        System.out.println("Det største tal: " + stoerste);
        System.out.println("Det mindste tal: " + mindste);
    }
}