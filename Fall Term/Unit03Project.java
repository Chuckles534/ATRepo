import java.util.Scanner;

public class Unit03Project {

    // Enumerations 
    enum CustomerType { BABY, CHILD, ADULT, SENIOR }
    enum DayOfWeek { MON, TUE, WED, THU, FRI, SAT, SUN }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Input
        System.out.print("name: ");
        String name = in.nextLine();

        System.out.print("day: ");
        String dayInput = in.nextLine().trim().toUpperCase();

        // Convert enum
        DayOfWeek day;
        if (dayInput.startsWith("MON")) day = DayOfWeek.MON;
        else if (dayInput.startsWith("TUE")) day = DayOfWeek.TUE;
        else if (dayInput.startsWith("WED")) day = DayOfWeek.WED;
        else if (dayInput.startsWith("THU")) day = DayOfWeek.THU;
        else if (dayInput.startsWith("FRI")) day = DayOfWeek.FRI;
        else if (dayInput.startsWith("SAT")) day = DayOfWeek.SAT;
        else if (dayInput.startsWith("SUN")) day = DayOfWeek.SUN;
        else {
            System.err.println("Error: Unknown day. Stopping program.");
            return;
        }

        // Time input 
        System.out.print("time (HH:MM): ");
        String time = in.nextLine().trim();

        if (!time.contains(":")) {
            System.err.println("Error: Time must include ':' character.");
            return;
        }

        int colonIndex = time.indexOf(':');
        String hourText = time.substring(0, colonIndex);
        String minuteText = time.substring(colonIndex + 1);

        // Validate 
        if (!isNumeric(hourText) || !isNumeric(minuteText)) {
            System.err.println("Error: Hour and minute must be numbers.");
            return;
        }

        int hour = Integer.parseInt(hourText);
        int minute = Integer.parseInt(minuteText);

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            System.err.println("Error: Invalid time entered.");
            return;
        }

        // Age input
        System.out.print("age: ");
        String ageText = in.nextLine().trim();
        if (!isNumeric(ageText)) {
            System.err.println("Error: Age must be a number.");
            return;
        }
        int age = Integer.parseInt(ageText);

        // Student status
        System.out.print("student (y/n)?: ");
        String studentInput = in.nextLine().trim().toLowerCase();
        boolean student;
        if (studentInput.equals("y")) student = true;
        else if (studentInput.equals("n")) student = false;
        else {
            System.err.println("Error: Invalid student input. Stopping program.");
            return;
        }

        // Determine customer type
        CustomerType type;
        if (age <= 2) type = CustomerType.BABY;
        else if (age <= 12) type = CustomerType.CHILD;
        else if (age <= 59) type = CustomerType.ADULT;
        else type = CustomerType.SENIOR;

        // Determine base price
        double basePrice = 0.0;
        String baseLabel = "";

        boolean weekend = (day == DayOfWeek.SAT || day == DayOfWeek.SUN);

        if (weekend) {
            basePrice = 80.0;
            baseLabel = "WEEKEND FARE";
        } else if ((hour >= 6 && hour <= 7) || (hour >= 16 && hour <= 17)) {
            basePrice = 100.0;
            baseLabel = "RUSH HOUR FARE";
        } else {
            basePrice = 90.0;
            baseLabel = "NON-RUSH HOUR FARE";
        }

        // Calculate discounts
        double ageDiscount = 0.0;
        double studentDiscount = 0.0;
        double finalCost;

        if (type == CustomerType.BABY) {
            finalCost = 0.0;
            baseLabel = "FREE (BABY)";
        } else {
            double afterAgeDiscount = basePrice;
            if (type == CustomerType.CHILD) {
                ageDiscount = basePrice * 0.20;
                afterAgeDiscount -= ageDiscount;
            } else if (type == CustomerType.SENIOR) {
                ageDiscount = basePrice * 0.25;
                afterAgeDiscount -= ageDiscount;
            }

            if (student) {
                studentDiscount = afterAgeDiscount * 0.05;
            }

            finalCost = afterAgeDiscount - studentDiscount;
        }

        // Output
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("Name:    " + name);
        System.out.println("Day:     " + day);
        System.out.println("Time:    " + time);
        System.out.println("------------------------------------------------------");
        System.out.printf("Base Price:       $%.2f (%s)%n", basePrice, baseLabel);
        System.out.printf("Age Discount:     $%.2f (%s)%n", -ageDiscount, type);
        System.out.printf("Student Discount: $%.2f%n", -studentDiscount);
        System.out.println("------------------------------------------------------");
        System.out.printf("Final Cost:       $%.2f%n", finalCost);
        System.out.println("------------------------------------------------------");
    }

     public static boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;

    }
}



