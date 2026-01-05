import java.util.Scanner;

public class ProgressBar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a value from 0 to 20: ");
        int value = input.nextInt();

        int percent = (value * 100) / 20;

        String bar = "[";

        for (int i = 0; i < value; i++) {
            bar += "#";
        }
        for (int i = value; i < 20; i++) {
            bar += "-";
        }

        bar += "]";

        System.out.println("Progress: " + bar + " " + percent + "%");
    }
}

