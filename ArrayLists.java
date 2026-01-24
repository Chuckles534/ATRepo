import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLists {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        while (true) {
            System.out.print("Enter a name or # to quit: ");
            String name = input.nextLine();

            if (name.equals("#")) {
                break;
            }

            names.add(name);
        }

        System.out.println("\nNames:");
        for (String n : names) {
            System.out.println(n);
        }
        input.close();
    }
}
