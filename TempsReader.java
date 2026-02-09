import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TempsReader {
    public static void main(String[] args) {
        ArrayList<Integer> temps = new ArrayList<>();
        int lowest = Integer.MAX_VALUE;

        try {
            File file = new File("temps.txt");
            Scanner input = new Scanner(file);

            // Read all integers and find lowest
            while (input.hasNextInt()) {
                int temp = input.nextInt();
                temps.add(temp);

                if (temp < lowest) {
                    lowest = temp;
                }
            }
            input.close();

            // Print all temperatures, marking lowest
            for (int t : temps) {
                if (t == lowest) {
                    System.out.println(t + " <= lowest");
                } else {
                    System.out.println(t);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
