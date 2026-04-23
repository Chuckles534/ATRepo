import java.util.Scanner;
import mow.Yard;
import mow.Mower;

public class YardDemo {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter lawn height: ");
        int h = sc.nextInt();

        System.out.print("Enter lawn width: ");
        int w = sc.nextInt();

        Yard y = new Yard(h, w);
        Mower m = new Mower();

        m.randomize(y);

        while (true) {
            clearScreen();
            y.print(m);
            Thread.sleep(200);

            boolean keepGoing = m.updateMower(y);
            if (!keepGoing) {
                break;
            }
        }

        clearScreen();
        y.print(m);
        System.out.println("Lawn is fully mowed.");

        sc.close();
    }

    public static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}