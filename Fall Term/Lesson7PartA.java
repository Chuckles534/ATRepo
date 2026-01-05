import java.util.Scanner;

public class Lesson7PartA {
    public static void main(String[] args) {
                Scanner input = new Scanner(System.in);

        // Monday
        System.out.print("Is today Monday? (yes or no): ");
        String dayResponse = input.nextLine().toLowerCase();
        boolean isMonday = dayResponse.startsWith("y");

        // Customer
        System.out.print("Enter the age of the customer: ");
        int age = input.nextInt();

        System.out.print("Enter the cost of the meal: $");
        double mealCost = input.nextDouble();

        // Discount
        double discountRate = 0.0;

        if (isMonday) {
            if (age < 13) {
                discountRate = 0.075; 
            } else if (age >= 50) {
                discountRate = 0.15;  
            } else {
                discountRate = 0.05;  
            }
        } else { 
            if (age < 13) {
                discountRate = 0.05;  
            } else if (age >= 50) {
                discountRate = 0.075; 
            } else {
                discountRate = 0.0;   
            }
        }

        // Calculate
        double discountAmount = mealCost * discountRate;
        double finalCost = mealCost - discountAmount;

        // Display
        System.out.printf("Discount: $%.2f (%.1f%%)\n", discountAmount, discountRate * 100);
        System.out.printf("Final cost after discount: $%.2f\n", finalCost);

        input.close();
    }
}

