import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {
    private List<Card> dealerCards;
    private List<Card> playerCards;
    private Scanner scanner;
    private Deck deck;

    public Blackjack() {
        scanner = new Scanner(System.in);
        deck = new Deck();
        dealerCards = new ArrayList<>();
        playerCards = new ArrayList<>();

        System.out.println("Welcome to Blackjack!");
        System.out.println("Dealing for the dealer!");
        dealerCards.add(deck.dealCard());
        dealerCards.add(deck.dealCard());
        System.out.println("Dealing for you!");
        playerCards.add(deck.dealCard());
        playerCards.add(deck.dealCard());
    }

    private void run() {
        boolean hasBusted = false;
        System.out.println("Your cards are: "+getCardName(playerCards, 0)+" and "+getCardName(playerCards, 1));
        int playerTotal = calculateValue(playerCards);
        int dealerValue = calculateValue(dealerCards);
        System.out.println("Your total: "+playerTotal);
        while (playerTotal <= 21) {
            System.out.print("Hit? (Type 'yes' to hit, 'stay' to stay) ");
            String yourMove = scanner.nextLine();
            if (yourMove.equals("stay"))
                break;
            else if (yourMove.equals("hit")) {
                playerCards.add(deck.dealCard());
                playerTotal = calculateValue(playerCards);
                System.out.println("Your total: "+playerTotal);
            }
        }
        if (playerTotal > 21) {
            System.out.println("You Busted!");
            System.out.println("You lose..");
            System.exit(0);
        }

        System.out.println("Dealer's turn to play!");
        while (dealerValue < 16) {
            System.out.println("Dealer: Hit.");
            dealerCards.add(deck.dealCard());
            dealerValue = calculateValue(dealerCards);
        }

        if (dealerValue > 21) {
            System.out.println("Dealer has busted!");
            System.out.println("You win!");
        } else {
            if (dealerValue < playerTotal)
                System.out.println("You win!");
            else if (dealerValue == playerTotal)
                System.out.println("Tie!");
            else System.out.println("You lose..");
        }

    }

    private String getCardName(List<Card> cards, int index) {
        return cards.get(index).getName()+" of "+cards.get(index).getSuit();
    }

    private int calculateValue(List<Card> cards) {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getValue();
            if (sum < 12 && card.getValue() == 1)
                sum += 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        blackjack.run();
    }
}
