import java.util.Scanner;

public class LetterGradeDebug {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = in.nextLine();

        int total = 0;

        // BUG 1: min initialized incorrectly.
        // min should start high (e.g., 100) so that the first score can lower it.
        // int min = 0;
        int min = 100;  // FIX

        // BUG 2: max initialized incorrectly.
        // max should start very low (e.g., 0), not -1.
        // int max = -1;
        int max = 0;   // FIX

        final int COUNT = 4;

        for (int i = 1; i <= COUNT; i++) {
            System.out.print("Enter score " + i + " (0-100): ");
            int s = in.nextInt();

            // BUG 3: Validation used wrong condition "&&"
            // The score cannot be both <0 AND >100 at the same time.
            // if (s < 0 && s > 100) {
            // FIX:
            if (s < 0) {
                s = 0;
            } else if (s > 100) {
                s = 100;
            }

            if (s < min) min = s;
            if (s > max) max = s;

            total += s;
        }

        // BUG 4: Incorrect average calculation due to integer division.
        // double avg = (double) (total / COUNT);
        double avg = total / (double) COUNT; // FIX

        // BUG 5: Passing logic incorrect because of stray semicolon
        // if (avg >= 60) ;
        // {
        //     passed = true;
        // }
        boolean passed = false;
        if (avg >= 60) {
            passed = true;      // FIX
        }

        char letter;
        if (avg >= 90) letter = 'A';
        else if (avg >= 80) letter = 'B';
        else if (avg >= 70) letter = 'C';
        else if (avg >= 60) letter = 'D';
        else letter = 'F';

        System.out.println("\n----- Report -----");
        System.out.println("Name: " + name);
        System.out.println("Highest single score recorded: " + max);
        System.out.println("Lowest single score recorded: " + min);
        System.out.println("Passed? " + passed);
        System.out.printf("Average: %.2f\n", avg);
        System.out.println("Letter grade: " + letter);

        in.close();
    }
}
