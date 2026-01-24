public class ProjectEuler {

    // Check if a number is prime 
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        int number = 1;
        int target = 10001;

        while (count < target) {
            number++;
            if (isPrime(number)) {
                count++;
            }
        }

        System.out.println("The 10001st prime is: " + number);
    }
}
