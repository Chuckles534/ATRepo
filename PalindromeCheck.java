import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String text = input.nextLine();

        // Remove spaces and lowercase everything
        text = text.replaceAll(" ", "").toLowerCase();

        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        if (text.equals(reversed)) {
            System.out.println("It IS a palindrome!");
        } else {
            System.out.println("It is NOT a palindrome.");
        }
        input.close();
    }
}
