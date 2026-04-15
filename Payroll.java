public class Payroll {

    static class Employee {
        String name;
        double salary;

        Employee(String n, double s) {
            name = n;
            salary = s;
        }

        double getAnnualIncome() {
            return salary;
        }
    }

    static class Manager extends Employee {
        double bonus;

        Manager(String n, double s, double b) {
            super(n, s);
            bonus = b;
        }

        double getAnnualIncome() {
            return salary + bonus;
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee("Alice", 50000);
        Manager m = new Manager("Bob", 60000, 10000);

        System.out.println(e.name + ": " + e.getAnnualIncome());
        System.out.println(m.name + ": " + m.getAnnualIncome());
    }
}