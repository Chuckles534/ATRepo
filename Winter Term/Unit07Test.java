import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Unit07Test {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("mathmeet.txt");
        Scanner in = new Scanner(file);

        double total = 0;
        int count = 0;

        System.out.printf("%-20s %-20s %10s%n", "Name", "School", "Score");
        System.out.println("----------------------------------------------------------");

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] parts = line.split(", ");

            String name = parts[0];
            String school = parts[1];
            double score = Double.parseDouble(parts[2]);

            System.out.printf("%-20s %-20s %10.1f%n", name, school, score);

            total += score;
            count++;
        }

        in.close();

        double average = total / count;
        System.out.println("----------------------------------------------------------");
        System.out.printf("Average Score: %.2f%n", average);
    }
}
