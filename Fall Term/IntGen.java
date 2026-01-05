public class IntGen {
    public static void main(String[] args) {
        int total = 0;

        for (int i = 1; i <= 10; i++) {
            int num = (int)(Math.random() * 10) + 1;
            System.out.print(num + " ");
            total = total + num;
        }

        double average = total / 10.0;
        System.out.println("\nAverage of 10 numbers: " + average);
    }
}
