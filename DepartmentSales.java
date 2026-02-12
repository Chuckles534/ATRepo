import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DepartmentSales {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(new File("sales.txt"));

        input.useDelimiter(",|\\n");

        while (input.hasNext()) {

            String dept = input.next();
            String manager = input.next();
            String revenueText = input.next();

            double revenue;

            if (revenueText.equals(" n/a") || revenueText.equals("n/a")) {
                revenue = 0.0;
            } else {
                revenue = Double.parseDouble(revenueText);
            }

            System.out.printf("%-18s | %-10s | $%10.2f\n",
                    dept, manager, revenue);
        }

        input.close();
    }
}
