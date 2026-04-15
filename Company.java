public class Company {

    static class Employee {
        String name;
        double salary;

        Employee(String n, double s) {
            name = n;
            salary = s;
        }

        void displayInfo() {
            System.out.println(name + " | Salary: " + salary);
        }
    }

    static class Manager extends Employee {
        double bonus;

        Manager(String n, double s, double b) {
            super(n, s);
            bonus = b;
        }

        void displayInfo() {
            System.out.println(name + " | Salary: " + salary + " | Bonus: " + bonus);
        }
    }

    static class Executive extends Manager {
        double shares;

        Executive(String n, double s, double b, double sh) {
            super(n, s, b);
            shares = sh;
        }

        // getter & setter
        double getShares() {
            return shares;
        }

        void setShares(double sh) {
            shares = sh;
        }

        // override
        void displayInfo() {
            System.out.println(name + " | Salary: " + salary +
                               " | Bonus: " + bonus +
                               " | Shares: " + shares);
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee("Alice", 50000);
        Manager m = new Manager("Bob", 60000, 10000);
        Executive ex = new Executive("Carol", 80000, 20000, 150);

        e.displayInfo();
        m.displayInfo();
        ex.displayInfo();
    }
}