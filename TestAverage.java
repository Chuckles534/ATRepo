    import java.util.Scanner;

public class TestAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double score, total = 0;
        int count = 0;

        System.out.println("Enter test scores. Enter a negative number to quit.");

        score = input.nextDouble();
        while (score >= 0) {
            total = total + score;
            count = count + 1;
            score = input.nextDouble();
        }

        if (count > 0) {
            double average = total / count;
            System.out.println("You entered " + count + " scores.");
            System.out.println("Average score: " + average);
        } else {
            System.out.println("No scores entered.");
        }
        input.close();
    }
}
