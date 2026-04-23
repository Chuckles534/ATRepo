import java.util.Scanner;
import mow.Yard;
import mow.Mower;

public class YardDemo {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter height: ");
        int h = sc.nextInt();

        System.out.print("Enter width: ");
        int w = sc.nextInt();

        System.out.println();

        Yard y = new Yard(h, w);

        // place mower on the left side of the lawn, facing right
        Mower m = new Mower(3, 1, 1);

        while (!m.frontIsBrick(y)) {
            m.cutGrass(y);

            clearScreen();
            y.print(m);
            Thread.sleep(500);

            m.moveForward();
        }

        // cut the last square and print one more time
        m.cutGrass(y);
        clearScreen();
        y.print(m);

        sc.close();
    }

    public static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}