import java.util.Arrays;

public class Unit6TestA {

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 8, 9};

        swap(2, 7, numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void swap(int i, int j, int[] arr) {
        if (arr == null) {
            return;
        }

        if (i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
