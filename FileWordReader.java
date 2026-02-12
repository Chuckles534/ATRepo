import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileWordReader {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a filename or # to quit: ");
            String fileName = keyboard.nextLine();

            if (fileName.equals("#")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                File file = new File(fileName);
                Scanner inputFile = new Scanner(file);

                while (inputFile.hasNext()) {
                    String word = inputFile.next();
                    System.out.println(word);
                }

                inputFile.close();
                System.out.println("Finished reading file.\n");
                break;  // End program after successful read

            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
                System.out.println("Please try again.\n");
            }
        }

        keyboard.close();
    }
}
