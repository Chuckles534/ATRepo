import java.time.LocalDate;
import java.time.LocalTime;

public class DateTime {
    public static void main(String[] args) {

        // Package: java.time
        // Parent packages: java

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println("Today's date is " + date);
        System.out.println("The time is " + time);
    }
}