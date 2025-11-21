public class NestedPattern {
    public static void main(String[] args) {
        for (int row = 1; row <= 5; row++) {

            // print dots
            for (int dots = 5 - row; dots > 0; dots--) {
                System.out.print(".");
            }

            // print numbers
            for (int num = 1; num <= row; num++) {
                System.out.print(row);
            }

            System.out.println();
        }
    }
}
