import java.util.Scanner;

public class QuizScoreTest {

    public static int getQuizScore(Scanner in) {
        System.out.print("Enter a quiz score (0-100): ");
        
        String input = in.nextLine();   // read as String
        
        int score = Integer.parseInt(input);  // may throw NumberFormatException
        
        if (score < 0 || score > 100) {
            throw new NumberFormatException("Score out of range");
        }
        
        return score;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            int quizScore = getQuizScore(in);
            System.out.println("Valid quiz score: " + quizScore);
        } catch (NumberFormatException e) {
            System.out.println("Invalid quiz score entered.");
        }

        in.close();
    }
}
