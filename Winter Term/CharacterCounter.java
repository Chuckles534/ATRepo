import java.io.FileReader;
import java.io.IOException;

public class CharacterCounter {
    public static void main(String[] args) {
        int count = 0;
        int letters = 0;
        int digits = 0;

        try {
            FileReader reader = new FileReader("text.txt");
            int ch;

            while ((ch = reader.read()) != -1) {
                char c = (char) ch;
                System.out.print(c);

                count++;

                if (Character.isLetter(c))
                    letters++;

                if (Character.isDigit(c))
                    digits++;
            }

            reader.close();

            System.out.println("\ncount = " + count);
            System.out.println("letters = " + letters);
            System.out.println("digits = " + digits);

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
