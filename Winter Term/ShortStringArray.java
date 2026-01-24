import java.util.Arrays;

public class ShortStringArray {

    public static void main(String[] args) {

        System.out.println("Average 1: " + average(10, 8, 9));

        double[] scores = {100, 90, 80, 100, 80};

        // Example of copying only valid values (important note)
        double[] validScores = Arrays.copyOf(scores, scores.length);

        System.out.println("Average 2: " + average(validScores));
    }

    public static double average(double... values) {
        if (values.length == 0) {
            return 0;
        }

        double sum = 0;
        for (double v : values) {
            sum += v;
        }

        return sum / values.length;
    }
}
