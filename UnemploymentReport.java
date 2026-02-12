import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UnemploymentReport {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(new File("unemployment.txt"));

        // Tell scanner to separate data by comma
        input.useDelimiter(",|\\n");

        System.out.println("---------------------------------------------------------------");
        System.out.println("                   Top 5 Unemployment Rates");
        System.out.println("---------------------------------------------------------------");

        while (input.hasNext()) {

            String country = input.next();
            double rate = input.nextDouble();
            int rank = input.nextInt();
            String region = input.next();

            System.out.printf("Ranked # %2d: %-17s | %6.2f%% | %-21s\n",
                    rank, country, rate, region);
        }

        System.out.println("---------------------------------------------------------------");

        input.close();
    }
}
