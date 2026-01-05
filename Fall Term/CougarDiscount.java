import java.util.Scanner;

public class CougarDiscount {

            enum CustomerType {
        CHILD, ADULT, SENIOR
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Is today Monday? (yes or no): ");
        String day = input.nextLine().toLowerCase();

        System.out.print("Enter the customer's age: ");
        int age = input.nextInt();

        System.out.print("Enter the cost of the meal: ");
        double cost = input.nextDouble();

        // Determine customer type
        CustomerType type;
        if (age < 13) {
            type = CustomerType.CHILD;
        } else if (age >= 50) {
            type = CustomerType.SENIOR;
        } else {
            type = CustomerType.ADULT;
        }

        // Figure out discount
        double discountRate = 0.0;

        if (day.equals("yes")) { // Monday
            if (type == CustomerType.CHILD) {
                discountRate = 0.075;
            } else if (type == CustomerType.SENIOR) {
                discountRate = 0.15;
            } else {
                discountRate = 0.05;
            }
        } else { // Tue - Sun
            if (type == CustomerType.CHILD) {
                discountRate = 0.05;
            } else if (type == CustomerType.SENIOR) {
                discountRate = 0.075;
            } else {
                discountRate = 0.0;
            }
        }

        double discount = cost * discountRate;
        double finalCost = cost - discount;

        System.out.println();
        System.out.println("Customer type: " + type);
        System.out.printf("Discount: $%.2f (%.1f%%)\n", discount, discountRate * 100);
        System.out.printf("Final cost: $%.2f\n", finalCost);

        input.close();
    }
}

