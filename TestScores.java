import java.util.Scanner;

public class TestScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] scores = new double[10];
        int count = 0;
        double sum = 0, max = 0;

        System.out.println("Enter test scores (or q to quit):");

        while (count < 10) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("q")) break;

            double score = Double.parseDouble(input);
            scores[count] = score;
            sum += score;
            if (count == 0 || score > max) max = score;
            count++;
        }

        if (count > 0) {
            System.out.println("Count: " + count);
            System.out.println("Average: " + (sum / count));
            System.out.println("Max: " + max);
        }

        sc.close();
    }
}
