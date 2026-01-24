public class SmallestTest {
    public static double smallest(double x, double y, double z)
    {
        double min = x;

        if (y < min)
            min = y;
        if (z < min)
            min = z;

        return min;
    }

    public static void main(String[] args)
    {
        System.out.println(smallest(3.5, 2.1, 4.9));  // 2.1
        System.out.println(smallest(-1.0, -5.2, 0));  // -5.2
    }
}
