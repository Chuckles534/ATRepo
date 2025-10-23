import java.util.Scanner;
public class Cafe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Is today Monday? (yes/no): ");
        String isMonday = input.nextLine().trim().toLowerCase();

        System.out.print("Enter the customer's age: ");
        int age = input.nextInt();

        System.out.print("Enter the cost of the meal: $");
        double cost = input.nextDouble();

        double discountRate = 0.0;

        // Discount
        if (isMonday.equals("yes")) {
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
                
             // No discount Tue-Sun for others
            } else {
                discountRate = 0.0;   
            }
        }

        // Calculate final price
        double discountAmount = cost * discountRate;
        double finalCost = cost - discountAmount;

        // Display 
        System.out.printf("Discount: $%.2f (%.1f%%)%n", discountAmount, discountRate * 100);
        System.out.printf("Final cost: $%.2f%n", finalCost);
    }
}
    

