import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the APR (as a percentage, for example, 5.5): ");
        double apr = input.nextDouble();
        System.out.print("Enter the balance: ");
        double balance = input.nextDouble();

        System.out.println("Year |        Int Earned ($)       |           Balance ($)");
        System.out.println("----------------------------------------------------------------------");

        for (int year = 1; year <= 5; year++) {
            double interest = balance * (apr / 100.0);
            balance += interest;
            System.out.printf("%3d  | %25.2f | %25.2f\n", year, interest, balance);
        }

        input.close();
    }
}


