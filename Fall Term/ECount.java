import java.util.Scanner;

public class ECount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a phrase: ");
        String phrase = input.nextLine();

        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == 'e' || phrase.charAt(i) == 'E') {
                count = count + 1;
            }
        }

        System.out.println("The letter 'e' appears " + count + " times.");
    }
}
