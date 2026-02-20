import java.util.Scanner;

public class CashRegister {
    private double total;
    private int count;

    public CashRegister() {
        total = 0;
        count = 0;
    }

    public void addItem(double price) {
        total += price;
        count++;
    }

    public void removeItem() {
        if (count > 0) {
            total -= total / count;
            count--;
        }
    }

    public void clear() {
        total = 0;
        count = 0;
    }

    public double getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CashRegister register = new CashRegister();

        String userInput = "";

        while (!userInput.equals("q")) {

            System.out.println("\nEnter a price to add.");
            System.out.println("t = show total");
            System.out.println("d = delete last item");
            System.out.println("c = clear");
            System.out.println("q = quit");

            userInput = input.nextLine();

            if (userInput.equals("t")) {
                System.out.println("Items: " + register.getCount());
                System.out.printf("Total: $%.2f\n", register.getTotal());

            } else if (userInput.equals("d")) {
                register.removeItem();
                System.out.println("Last item removed.");

            } else if (userInput.equals("c")) {
                register.clear();
                System.out.println("Register cleared.");

            } else if (userInput.equals("q")) {
                System.out.println("Goodbye!");

            } else {
                try {
                    double price = Double.parseDouble(userInput);
                    register.addItem(price);
                    System.out.println("Item added.");
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                }
            }
        }

        input.close();
    }
}