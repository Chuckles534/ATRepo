import java.util.Scanner;

public class BugFixB {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter number of cookies: ");
    int num = in.nextInt();
    double discount = 0.0;   // FIX: initialize

    if (num > 12) {          // FIX: check biggest amount first
        discount = 0.10;
    } else if (num > 6) {
        discount = 0.05;
    }

    System.out.println("Discount = " + discount);  
    in.close();
}

}
