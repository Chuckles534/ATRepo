import org.derryfield.math.Algebra;
import java.util.Scanner;

public class Unit08TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first positive number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second positive number: ");
        double num2 = scanner.nextDouble();

        try {
            double result = Unit08Test.harmonicMean(num1, num2);
            System.out.println("Harmonic mean of " + num1 + " and " + num2 + " is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}