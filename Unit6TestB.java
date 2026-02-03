import java.util.ArrayList;
import java.util.Scanner;

public class Unit6TestB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<>();

        // INPUT 

        while (true) {
            System.out.print("Enter a quiz score or 'q' to quit: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            double score = Double.parseDouble(input);
            scores.add(score);
        }

        // If no scores were entered, stop the program
        if (scores.isEmpty()) {
            System.out.println("\nNo scores entered.");
            scanner.close();
            return;
        }

        // OUTPUT 
        System.out.println("\nQuiz Scores:");
        for (double s : scores) {
            System.out.printf("%6.2f%n", s);
        }

        // AVERAGE 
        double sum = 0.0;
        for (double s : scores) {
            sum += s;
        }

        double average = sum / scores.size();

        System.out.printf("\nAverage: %6.2f%n", average);

        scanner.close();
    }
}
