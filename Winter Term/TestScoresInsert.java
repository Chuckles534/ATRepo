public class TestScoresInsert {

    public static void main(String[] args) {

        double[] scores = {80, 90, 75, 88, 92, 0, 0, 0, 0, 0};
        int currentSize = 5;

        System.out.println("Before insert:");
        printArray(scores, currentSize);

        currentSize = insert(scores, currentSize, 1, 85);

        System.out.println("After inserting 85 at index 1:");
        printArray(scores, currentSize);
    }

    public static int insert(double[] array, int currentSize,
                             int targetIndex, double newElement) {

        if (currentSize == array.length ||
            targetIndex < 0 || targetIndex > currentSize) {
            return currentSize;
        }

        for (int i = currentSize; i > targetIndex; i--) {
            array[i] = array[i - 1];
        }

        array[targetIndex] = newElement;
        return currentSize + 1;
    }

    public static void printArray(double[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
