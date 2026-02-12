import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BirthYearReader {
    public static void main(String[] args) {

        try {
            File file = new File("people.txt");
            Scanner inputFile = new Scanner(file);

            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                String[] parts = line.split(",");

                String name = parts[0];
                String yearString = parts[1];

                try {
                    int birthYear = Integer.parseInt(yearString);
                    System.out.println(name + " was born in " + birthYear + ".");
                } catch (NumberFormatException e) {
                    System.out.println("I do not know what year " + name + " was born.");
                }
            }

            inputFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
