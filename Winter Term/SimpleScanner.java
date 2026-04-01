import java.util.Scanner;

public class SimpleScanner {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = in.nextLine();
        System.out.println("Name: " + name);

        System.out.print("How old are you? ");
        int age = in.nextInt();
        System.out.println("Age: " + age);

        in.close();
    }
}
