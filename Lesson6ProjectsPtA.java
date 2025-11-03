import java.util.Scanner;

public class Lesson6ProjectsPtA {
    public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
        System.out.print("Enter a temperature and a 'C' for Celsius or 'F' for Fahrenheit: ");
        double temperature = input.nextDouble();
        char scale = input.next().toUpperCase().charAt(0);

        double tempCelsius;

        // Convert to Celsius if input is Fahrenheit
        if (scale == 'F') {
            tempCelsius = (temperature - 32) * 5 / 9;
        } else if (scale == 'C') {
            tempCelsius = temperature;
        } else {
            System.out.println("Invalid temperature scale. Please use 'C' or 'F'.");
            return;
        }

        String state;
        if (tempCelsius <= 0) {
            state = "solid (i.e., ice)";
        } else if (tempCelsius >= 100) {
            state = "gaseous (i.e., steam)";
        } else {
            state = "liquid (i.e., water)";
        }

        System.out.printf("At a temperature of %.2f %c, water is in a %s state.%n", temperature, scale, state);
        input.close();
    }
    
}
    
