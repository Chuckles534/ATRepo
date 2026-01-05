import java.util.Scanner;

public class Lesson7PartB {

    enum CustomerType { CHILD, ADULT, SENIOR }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Is today Monday? (yes or no): ");
        String dayResponse = input.nextLine().trim().toLowerCase();
        boolean isMonday = dayResponse.startsWith("y");

        System.out.print("Enter the age of the customer: ");
        int age = input.nextInt();

        System.out.print("Enter the cost of the meal: $");
        double mealCost = input.nextDouble();

        // Customer
        CustomerType type;
        if (age < 13) {
            type = CustomerType.CHILD;
        } else if (age >= 50) {
            type = CustomerType.SENIOR;
        } else {
            type = CustomerType.ADULT;
        }

        // Calculate Discount
        double discountRate = 0.0;

        if (isMonday) {
            if (type == CustomerType.CHILD) {
                discountRate = 0.075;   
            } else if (type == CustomerType.SENIOR) {
                discountRate = 0.15;   
            } else { 
                discountRate = 0.05;   
            }
        } else { 
            if (type == CustomerType.CHILD) {
                discountRate = 0.05;   
            } else if (type == CustomerType.SENIOR) {
                discountRate = 0.075;   
            } else { 
                discountRate = 0.0;   
            }
        }

        double discountAmount = mealCost * discountRate;
        double finalCost = mealCost - discountAmount;

        System.out.println("\nCustomer Type: " + type);
        System.out.printf("Discount: $%.2f (%.1f%%)%n", discountAmount, discountRate * 100);
        System.out.printf("Final cost after discount: $%.2f%n", finalCost);

        input.close();
    }
}
