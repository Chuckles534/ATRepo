public class TwoArray {

    public static void main(String[] args) {

        int[][] firstArray = {
            {8, 6, 7},
            {5, 3, 0}
        };

        int[][] secondArray = {
            {0, 7, 6, 5},
            {2, 2, 0, 1},
            {8, 4, 5, 7}
        };

        System.out.println("First array:");
        print(firstArray);

        System.out.println("\nSecond array:");
        print(secondArray);
    }

    public static void print(int[][] values) {
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                System.out.printf("%3d", values[row][col]);
                if (col < values[row].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
