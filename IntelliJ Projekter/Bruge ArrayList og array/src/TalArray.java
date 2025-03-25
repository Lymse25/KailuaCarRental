public class TalArray {
    public static int findSum(int[] tal) {
        int sum = 0;
        for (int t : tal) {
            sum += t;
        }
        return sum;
    }

    public static double findGennemsnit(int[] tal) {
        return (double) findSum(tal) / tal.length;
    }

    public static int findStoerste(int[] tal) {
        int max = tal[0];
        for (int t : tal) {
            if (t > max) {
                max = t;
            }
        }
        return max;
    }

    public static int findMindste(int[] tal) {
        int min = tal[0];
        for (int t : tal) {
            if (t < min) {
                min = t;
            }
        }
        return min;
    }
}