import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] a = new int[10];
        int size = 0;

        while (size < a.length) {
            System.out.print("Enter an integer value or 'q' to quit: ");
            if (in.hasNext("q") || in.hasNext("Q")) { in.next(); break; }
            a[size++] = in.nextInt();
        }

        System.out.print("*");
        for (int i = 0; i < size; i++) System.out.print(a[i] + "*");
        System.out.println();

        Arrays.sort(a, 0, size);
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(a[i]);
            if (i > 0) System.out.print(",");
        }
        System.out.println();

        in.close();
    }
}
