import java.util.Scanner;

public class DiceRoller {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int roll = 0;
        String choice = "";

        while (!choice.equals("q")) {
            System.out.print("Enter 'r' to roll, 'd' to display, or 'q' to quit: ");
            choice = input.nextLine();

            if (choice.equals("r")) {
                roll = (int)(Math.random() * 6) + 1;
            } 
            else if (choice.equals("d")) {
                System.out.println("+-------+");

                if (roll == 1) {
                    System.out.println("|       |");
                    System.out.println("|   0   |");
                    System.out.println("|       |");
                } 
                else if (roll == 2) {
                    System.out.println("| 0     |");
                    System.out.println("|       |");
                    System.out.println("|     0 |");
                } 
                else if (roll == 3) {
                    System.out.println("| 0     |");
                    System.out.println("|   0   |");
                    System.out.println("|     0 |");
                } 
                else if (roll == 4) {
                    System.out.println("| 0   0 |");
                    System.out.println("|       |");
                    System.out.println("| 0   0 |");
                } 
                else if (roll == 5) {
                    System.out.println("| 0   0 |");
                    System.out.println("|   0   |");
                    System.out.println("| 0   0 |");
                } 
                else if (roll == 6) {
                    System.out.println("| 0   0 |");
                    System.out.println("| 0   0 |");
                    System.out.println("| 0   0 |");
                } 
                else {
                    System.out.println("| 0     |");
                    System.out.println("|       |");
                    System.out.println("|     0 |");
                }

                System.out.println("+-------+");
            }
        }
    }
}
