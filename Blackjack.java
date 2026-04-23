import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Blackjack {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");

        while (true) {
            System.out.print("\nPlay a hand? (yes/no): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("no")) {
                System.out.println("Goodbye!");
                break;
            }

            playGame();
        }
    }

    public static void playGame() {
        ArrayList<Card> player = new ArrayList<>();
        ArrayList<Card> dealer = new ArrayList<>();

        // deal starting cards
        player.add(drawCard());
        player.add(drawCard());

        dealer.add(drawCard());
        Card hidden = drawCard();
        hidden.faceUp = false;
        dealer.add(hidden);

        System.out.println("\nYour hand:");
        printHand(player);
        System.out.println("Your score: " + getScore(player));

        System.out.println("\nDealer hand:");
        printHand(dealer);

        // player turn
        while (true) {
            System.out.print("\nHit or stand? ");
            String move = scanner.nextLine();

            if (move.equalsIgnoreCase("hit")) {
                Card newCard = drawCard();
                player.add(newCard);
                System.out.println("You drew: " + newCard);

                printHand(player);
                int score = getScore(player);
                System.out.println("Your score: " + score);

                if (score > 21) {
                    System.out.println("You busted. Dealer wins.");
                    return;
                }

            } else if (move.equalsIgnoreCase("stand")) {
                break;
            }
        }

        // dealer turn
        System.out.println("\nDealer reveals card:");
        dealer.get(1).faceUp = true;
        printHand(dealer);

        int dealerScore = getScore(dealer);

        while (dealerScore < 17) {
            Card newCard = drawCard();
            dealer.add(newCard);
            System.out.println("Dealer draws: " + newCard);

            dealerScore = getScore(dealer);
        }

        System.out.println("Dealer score: " + dealerScore);

        int playerScore = getScore(player);

        // decide winner
        if (dealerScore > 21) {
            System.out.println("Dealer busts. You win!");
        } else if (playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (dealerScore > playerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie.");
        }
    }

    public static Card drawCard() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
            "2","3","4","5","6","7","8","9","10",
            "Jack","Queen","King","Ace"
        };

        String suit = suits[random.nextInt(4)];
        String rank = ranks[random.nextInt(13)];

        return new Card(rank, suit);
    }

    public static int getScore(ArrayList<Card> hand) {
        int score = 0;
        int aces = 0;

        for (Card c : hand) {
            score += c.getValue();
            if (c.rank.equals("Ace")) {
                aces++;
            }
        }

        // fix aces if bust
        while (score > 21 && aces > 0) {
            score -= 10;
            aces--;
        }

        return score;
    }

    public static void printHand(ArrayList<Card> hand) {
        for (Card c : hand) {
            System.out.println(c);
        }
    }
}

class Card {
    String rank;
    String suit;
    boolean faceUp = true;

    public Card(String r, String s) {
        rank = r;
        suit = s;
    }

    public int getValue() {
        if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
            return 10;
        }
        if (rank.equals("Ace")) {
            return 11;
        }
        return Integer.parseInt(rank);
    }

    public String toString() {
        if (!faceUp) return "Hidden card";
        return rank + " of " + suit;
    }
}