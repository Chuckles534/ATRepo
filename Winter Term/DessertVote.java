import java.util.Scanner;

public class DessertVote {

    // Counter class inside the same file
    static class Counter {
        private int count = 0;

        public void addOne() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Counter cake = new Counter();
        Counter pie = new Counter();

        String answer = "";

        while (!answer.equals("q")) {
            System.out.print("Type c for cake, p for pie, q to quit: ");
            answer = in.next();

            if (answer.equals("c")) {
                cake.addOne();
            } 
            else if (answer.equals("p")) {
                pie.addOne();
            }
        }

        System.out.println("Cake votes: " + cake.getCount());
        System.out.println("Pie votes: " + pie.getCount());

        in.close();
    }
}
