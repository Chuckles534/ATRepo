import java.util.ArrayList;
import java.util.Scanner;

public class TempArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> temps = new ArrayList<>();

        while (true) {
            System.out.print("Enter a temperature or q to quit: ");
            String value = input.nextLine();

            if (value.equalsIgnoreCase("q")) {
                break;
            }

            temps.add(Integer.parseInt(value));
        }

        if (temps.isEmpty()) {
            return;
        }

        int lowest = temps.get(0);
        for (int t : temps) {
            if (t < lowest) {
                lowest = t;
            }
        }

        System.out.println("\nTemperatures:");
        for (int t : temps) {
            if (t == lowest) {
                System.out.println(t + " <= lowest");
            } else {
                System.out.println(t);
            }
        }
        input.close();
    }
}
