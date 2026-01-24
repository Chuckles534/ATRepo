import java.util.Scanner;

public class StringArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] words = new String[10]; // partially filled array
        int size = 0;

        while (true) {
            System.out.print("Enter a word or phrase or 'q' to quit: ");
            String line = input.nextLine();

            if (line.equals("q")) {
                break;
            }

            if (size < words.length) {
                words[size] = line;
                size++;
            }
        }

        // Print original array
        System.out.println("\nWords/Phrases (current size = " + size + "):");
        for (int i = 0; i < size; i++) {
            System.out.println("  " + words[i]);
        }

        // Clean up array
        cleanup(words, size);

        // Print modified array
        System.out.println("\nModified array...");
        System.out.println("Words/Phrases (current size = " + size + "):");
        for (int i = 0; i < size; i++) {
            System.out.println("  " + words[i]);
        }

        input.close();
    }

    // Cleanup method
    public static void cleanup(String[] arr, int size) {
        for (int i = 0; i < size; i++) {
            String s = arr[i].trim().toLowerCase();

            if (s.length() > 0) {
                s = s.substring(0, 1).toUpperCase() + s.substring(1);
            }

            arr[i] = s;
        }
    }
}
