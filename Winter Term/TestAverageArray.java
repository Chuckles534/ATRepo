import java.util.ArrayList;
import java.util.Scanner;

public class TestAverageArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<>();

        while (true) {
            System.out.print("Enter a test score or q to quit: ");
            String value = input.nextLine();

            if (value.equalsIgnoreCase("q")) {
                break;
            }

            scores.add(Double.parseDouble(value));
        }

        double sum = 0;

        System.out.println("\nScores:");
        for (double score : scores) {
            System.out.printf("%.2f%n", score);
            sum += score;
        }

        if (!scores.isEmpty()) {
            double average = sum / scores.size();
            System.out.printf("Average: %.2f%n", average);
        }
        input.close();
    }
}
