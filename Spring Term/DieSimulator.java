import java.util.Scanner;

public class DieSimulator {

    static class Die {
        int value;
        
        Die() {
            roll();
        }

        Die(int v) {
            value = v;
        }

        void roll() {
            value = (int)(Math.random() * 6) + 1;
        }

        int getValue() {
            return value;
        }

        public String toString() {
            if (value == 1)
                return "+-------+\n|       |\n|   0   |\n|       |\n+-------+";
            if (value == 2)
                return "+-------+\n| 0     |\n|       |\n|     0 |\n+-------+";
            if (value == 3)
                return "+-------+\n| 0     |\n|   0   |\n|     0 |\n+-------+";
            if (value == 4)
                return "+-------+\n| 0   0 |\n|       |\n| 0   0 |\n+-------+";
            if (value == 5)
                return "+-------+\n| 0   0 |\n|   0   |\n| 0   0 |\n+-------+";
            return "+-------+\n| 0   0 |\n| 0   0 |\n| 0   0 |\n+-------+";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Die die = new Die();

        while (true) {
            System.out.print("Enter r, d, or q: ");
            String choice = input.nextLine();

            if (choice.equals("r")) {
                die.roll();
                System.out.println("Rolled: " + die.getValue());
            } else if (choice.equals("d")) {
                System.out.println(die);
            } else if (choice.equals("q")) {
                System.out.println("Bye!");
                break;
            }
        }
    }
}