import java.util.ArrayList;
import java.util.Scanner;

public class OddNumArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            System.out.print("Enter an integer or q to quit: ");
            String value = input.nextLine();

            if (value.equalsIgnoreCase("q")) {
                break;
            }

            numbers.add(Integer.parseInt(value));
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 != 0) {
                numbers.remove(i);
            }
        }

        System.out.println("\nEven Numbers Only:");
        for (int num : numbers) {
            System.out.println(num);
        }
        input.close();
    }
}
