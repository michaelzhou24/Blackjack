public class Card {
    private int value;
    private boolean isAce;
    private String suit;
    private String name;

    public Card(int value, String suit) {
        if (value > 10) {
            this.value = 10;
            if (value == 11)
                name = "Jack";
            else if (value == 12)
                name = "Queen";
            else if (value == 13)
                name = "King";
        } else {
            this.value = value;
            name = String.valueOf(value);
            if (value == 1) {
                isAce = true;
                name = "Ace";
            }
        }
        this.suit = suit;
    }

    public String getSuit() {
        if (suit.equals("s"))
            return "Spades";
        if (suit.equals("d"))
            return "Diamonds";
        if (suit.equals("c"))
            return "Clubs";
        if (suit.equals("h"))
            return "Hearts";
        return null;
    }

    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }

    public boolean isAce() {
        return isAce;
    }
}
