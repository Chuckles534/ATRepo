import java.io.*;
import java.util.Scanner;

public class QuizFormatter {
    public static void main(String[] args) {
        try {
            File inputFile = new File("quizzes.txt");
            Scanner input = new Scanner(inputFile);

            PrintWriter output = new PrintWriter("quizzesMod.txt");

            double sum = 0;
            int count = 0;

            while (input.hasNextDouble()) {
                double score = input.nextDouble();
                output.printf("Quiz %03d: %6.2f%n", count, score);
                sum += score;
                count++;
            }

            double average = sum / count;

            output.println("----------------");
            output.printf("Average: %6.2f%n", average);

            input.close();
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
