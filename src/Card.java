public class Card {

    private final String suit;
    private final String symbol;
    private final int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", symbol, suit);
    }
}
