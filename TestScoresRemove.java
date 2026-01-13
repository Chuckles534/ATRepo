public class TestScoresRemove {

    public static void main(String[] args) {

        double[] scores = {80, 90, 75, 88, 92, 0, 0, 0, 0, 0};
        int currentSize = 5;

        System.out.println("Before remove:");
        printArray(scores, currentSize);

        currentSize = remove(scores, currentSize, 2);

        System.out.println("After removing index 2:");
        printArray(scores, currentSize);
    }

    public static int remove(double[] array, int currentSize, int targetIndex) {
        if (targetIndex < 0 || targetIndex >= currentSize) {
            return currentSize;
        }

        for (int i = targetIndex; i < currentSize - 1; i++) {
            array[i] = array[i + 1];
        }

        return currentSize - 1;
    }

    public static void printArray(double[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
