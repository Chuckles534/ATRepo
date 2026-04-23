import java.util.Random;

public class Card {

    public enum Suit { SPADE, HEART, CLUB, DIAMOND }
    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private Suit suit;
    private Rank rank;

    // random constructor
    public Card() {
        Random r = new Random();
        suit = Suit.values()[r.nextInt(4)];
        rank = Rank.values()[r.nextInt(13)];
    }

    // given constructor
    public Card(Suit s, Rank r) {
        suit = s;
        rank = r;
    }

    public Suit getSuit() { return suit; }
    public Rank getRank() { return rank; }

    public String getFace() {
        char[] suits = {'\u2660','\u2661','\u2663','\u2662'}; // ♠ ♡ ♣ ♢
        char[] ranks = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};

        return "" + suits[suit.ordinal()] + ranks[rank.ordinal()];
    }

    public static void main(String[] args) {

        Card c = new Card(Suit.HEART, Rank.QUEEN);
        System.out.println("  " + c.getFace());

        System.out.println("10 random cards...");
        for (int i = 0; i < 10; i++) {
            System.out.println("  " + new Card().getFace());
        }
    }
}