public class MathDemo {
    public static void main(String[] args) {
        double radius = 5.0;

        // Java-provided constant static value
        double circumference = 2 * Math.PI * radius;

        // Java-provided static method
        double squareRoot = Math.sqrt(49);

        System.out.println("Radius: " + radius);
        System.out.println("Circumference: " + circumference);
        System.out.println("Square root of 49: " + squareRoot);
    }
}