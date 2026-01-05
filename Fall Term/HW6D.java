import java.util.Scanner;

public class HW6D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double COOKIE_PRICE = 0.99;

        // Prompt user for number of cookies
        System.out.print("Enter the number of cookies you want to buy: ");
        int numCookies = input.nextInt();

        double total = numCookies * COOKIE_PRICE;

        // Discount Rate
        double discountRate = 0.0;
        if (numCookies > 24) {
            discountRate = 0.15;
        } else if (numCookies > 12) {
            discountRate = 0.05;
        } else if (numCookies > 6) {
            discountRate = 0.025;
        }

        // Discount
        double discountAmount = total * discountRate;
        double finalTotal = total - discountAmount;

        // Display 
        System.out.printf("Number of cookies: %d%n", numCookies);
        System.out.printf("Total before discount: $%.2f%n", total);
        System.out.printf("Discount applied: %.1f%%%n", discountRate * 100);
        System.out.printf("Final total: $%.2f%n", finalTotal);

        input.close();
    }
}


