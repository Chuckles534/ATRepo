public class BugFixA {
    public static void main(String[] args) {
    String name = "Harry";
    System.out.println("The last letter of the name is " +
        name.charAt(name.length() - 1));   // FIX: subtract 1
}

}
