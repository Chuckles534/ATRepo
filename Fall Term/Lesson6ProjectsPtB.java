 import java.util.Scanner;

public class Lesson6ProjectsPtB {
 public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two floating-point numbers: ");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();

        // Round both numbers to two decimal places
        num1 = Math.round(num1 * 100.0) / 100.0;
        num2 = Math.round(num2 * 100.0) / 100.0;

        if (num1 == num2) {
            System.out.println("They are the same up to two decimal places.");
        } else {
            System.out.println("They are different.");
        }
    }
}