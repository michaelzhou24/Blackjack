import java.util.ArrayList;
import java.util.List;

public class Blackjack {
    private List<Card> dealerCards;
    private List<Card> playerCards;

    private Deck deck;

    public Blackjack() {
        deck = new Deck();
        dealerCards = new ArrayList<>();
        playerCards = new ArrayList<>();

        dealerCards.add(deck.dealCard());
        dealerCards.add(deck.dealCard());
        playerCards.add(deck.dealCard());
        playerCards.add(deck.dealCard());
    }

    public void run() {
        System.out.println("Welcome to Blackjack!");
        System.out.println("Your cards are: "+getCardName(playerCards, 0)+" and "+getCardName(playerCards, 1));
        calculateValue(playerCards);
    }

    private String getCardName(List<Card> cards, int index) {
        return cards.get(index).getName()+" of "+cards.get(index).getSuit();
    }

    private void calculateValue(List<Card> cards) {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getValue();
            if (sum < 12 && card.getValue() == 1)
                sum += 10;
        }
        System.out.println("Total Value: "+sum);
    }

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        blackjack.run();
    }
}
