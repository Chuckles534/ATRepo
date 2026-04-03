package org.derryfield.math;

public class Unit08Test {

    public static double harmonicMean(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Both values must be positive.");
        }
        if (a + b == 0) {
            throw new IllegalArgumentException("The sum of the values cannot be zero.");
        }
        return 2 * a * b / (a + b);
    }
}