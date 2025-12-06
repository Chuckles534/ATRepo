// used AI to ask how to get random numbers and got Random
import java.util.Random;

public class DiceRoll {
    public static void main(String[] args) {
        Random rand = new Random();
        
        int d1, d2;

        do {
            d1 = rand.nextInt(6) + 1;
            d2 = rand.nextInt(6) + 1;

            System.out.println("Dice 1: " + d1 + "   Dice 2: " + d2);

        } while (d1 != d2);

        System.out.println("Both dice matched! Stopping...");
    }
}

