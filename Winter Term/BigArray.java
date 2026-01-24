import java.util.Scanner;

public class BigArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] a = new int[20];
        int size = 0;

        while (size < a.length) {
            System.out.print("Enter an integer value or 'q' to quit: ");
            if (in.hasNext("q") || in.hasNext("Q")) { in.next(); break; }
            a[size++] = in.nextInt();
        }

        for (int i = 0; i < size; i++) {
            System.out.print(a[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println();

        System.out.print("Enter a target integer value: ");
        int target = in.nextInt();

        int count = 0;
        for (int i = 0; i < size; i++) if (a[i] == target) count++;

        System.out.println("The value " + target + " occurs " + count + " times in your original data set.");

        in.close();
    }
}
