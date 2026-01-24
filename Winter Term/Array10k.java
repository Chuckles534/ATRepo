import java.util.Arrays;
import java.util.Random;

public class Array10k {
    static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) if (a[i] == target) return i;
        return -1;
    }

    public static void main(String[] args) {
        int n = 10_000;
        int[] data = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) data[i] = r.nextInt(n) + 1;

        int[] sorted = Arrays.copyOf(data, n);
        Arrays.sort(sorted);

        int trials = 10;
        long linTotal = 0, binTotal = 0;

        for (int t = 1; t <= trials; t++) {
            int target = r.nextInt(n) + 1;

            long start = System.nanoTime();
            linearSearch(data, target);
            long linTime = System.nanoTime() - start;

            start = System.nanoTime();
            Arrays.binarySearch(sorted, target);
            long binTime = System.nanoTime() - start;

            linTotal += linTime;
            binTotal += binTime;

            System.out.println("Trial " + t + " target=" + target +
                    " linear=" + linTime + "ns binary=" + binTime + "ns");
        }

        System.out.println("Avg linear: " + (linTotal / trials) + " ns");
        System.out.println("Avg binary: " + (binTotal / trials) + " ns");
    }
}
