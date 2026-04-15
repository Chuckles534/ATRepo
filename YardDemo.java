import java.util.Scanner;
import mow.Yard;

public class YardDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter height: ");
        int h = sc.nextInt();

        System.out.print("Enter width: ");
        int w = sc.nextInt();

        System.out.println();

        Yard y = new Yard(h, w);
        y.printYard();

        sc.close();
    }
}