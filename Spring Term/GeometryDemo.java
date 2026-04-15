import java.util.Scanner;
import org.derryfield.math.Geometry;

public class GeometryDemo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter side length: ");
        double side = input.nextDouble();

        double perimeter = Geometry.get_perimeter_square(side);
        double area = Geometry.get_area_square(side);

        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);

        input.close();
    }
}