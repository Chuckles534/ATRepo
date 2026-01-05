import java.util.Arrays;
import java.util.Scanner;
public class Lesson6ProjectsPtC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three strings: ");
        String str1 = input.next();
        String str2 = input.next();
        String str3 = input.next();

        String[] words = {str1, str2, str3};
        Arrays.sort(words);

        for (String word : words) {
            System.out.println(word);
            
        input.close();
        }
    }
}

