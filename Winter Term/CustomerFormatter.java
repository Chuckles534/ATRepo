import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerFormatter {
    public static void main(String[] args) {
        try {
            File file = new File("customers.txt");
            Scanner input = new Scanner(file);

            // Change delimiter to comma, whitespace, or new line
            input.useDelimiter("[,\\s\\n]+");

            System.out.println("---------------------------------------");
            System.out.println("   ID  |    Name     |     Balance ");
            System.out.println("---------------------------------------");

            while (input.hasNext()) {
                int id = input.nextInt();
                String name = input.next();
                double balance = input.nextDouble();

                System.out.printf("%06d | %10s | $%,12.2f%n", id, name, balance);
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
