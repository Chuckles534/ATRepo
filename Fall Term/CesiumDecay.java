public class CesiumDecay {
    public static void main(String[] args) {
        double amount = 100.0;     
        int years = 0;            

        while (amount > 1.0) {     
            amount = amount / 2;   
            years += 30;           
        }

        System.out.println("Years required: " + years);
        System.out.println("Amount remaining: " + amount + "%");
    }
}


