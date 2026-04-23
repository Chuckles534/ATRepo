public class BaseballCard {

    String name;
    int year;

    public BaseballCard(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() { return name; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return name + " (" + year + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BaseballCard)) return false;

        BaseballCard other = (BaseballCard) obj;
        return name.equals(other.name) && year == other.year;
    }

    // demo in same file
    public static void main(String[] args) {

        BaseballCard c1 = new BaseballCard("Babe Ruth", 1927);
        BaseballCard c2 = new BaseballCard("Babe Ruth", 1927);
        BaseballCard c3 = new BaseballCard("Mickey Mantle", 1952);

        System.out.println("Card 1: " + c1);
        System.out.println("Card 2: " + c2);
        System.out.println("Card 3: " + c3);

        System.out.println("c1 equals c2: " + c1.equals(c2));
        System.out.println("c1 equals c3: " + c1.equals(c3));
    }
}