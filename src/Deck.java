import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            cards.add(new Card(i, "s"));
            cards.add(new Card(i, "c"));
            cards.add(new Card(i, "d"));
            cards.add(new Card(i, "h"));
        }
    }

    public Card dealCard() {
        Card dealtCard = cards.get(randomCard());
        cards.remove(dealtCard);
        System.out.println("Dealt a "+dealtCard.getName()+" of "+dealtCard.getSuit()+"!");
        return dealtCard;
    }

    private int randomCard() {
        return ThreadLocalRandom.current().nextInt(1, cards.size());
    }
}
