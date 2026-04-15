public class DieClass {
    private int value;
    private int SIDES = 6;

    // default constructor
    public DieClass() {
        roll();
    }

    // overloaded constructor
    public DieClass(int value) {
        this.value = value;
    }

    public void roll() {
        value = (int)(Math.random() * SIDES) + 1;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        if (value == 1) {
            return "+-------+\n|       |\n|   0   |\n|       |\n+-------+";
        } else if (value == 2) {
            return "+-------+\n| 0     |\n|       |\n|     0 |\n+-------+";
        } else if (value == 3) {
            return "+-------+\n| 0     |\n|   0   |\n|     0 |\n+-------+";
        } else {
            return "Value: " + value;
        }
    }
}