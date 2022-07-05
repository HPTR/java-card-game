import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CardGame {

    static ArrayList<Card> deckOfCards = new ArrayList<>();

    static {
        for (int i = 0; i < 4; i++) {

            String[] suits = new String[]{"\u2664", "\u2661", "\u2667", "\u2662"};

            for (int j = 0; j < 13; j++) {

                String[] symbols = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
                Integer[] values = new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

                deckOfCards.add(new Card(suits[i], symbols[j], values[j]));
            }
        }
    }

    public static void printCards(ArrayList<Card> cardArray) {
        for (Card card : cardArray) {
            System.out.println(card.toString());
        }
    }

    public static Card dealCard() {
        if (deckOfCards.size() > 0) {
            return deckOfCards.remove(0);
        } else {
            System.out.println("Out of cards!");
            return null;
        }
    }

    public static ArrayList<Card> sortDeckInNumberOrder() {
        ArrayList<Card> numSort = deckOfCards.stream()
                .sorted((c1, c2) -> c1.getValue() - c2.getValue()).collect(Collectors.toCollection(ArrayList::new));

        return deckOfCards = numSort;
    }

    public static ArrayList<Card> sortDeckIntoSuits() {
        deckOfCards.sort((c1, c2) -> c1.getSuit().compareTo(c2.getSuit()));
        return deckOfCards;
    }

    public static ArrayList<Card> shuffleDeck() {
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();

        for (int i = 0; i < 52; i++) {
            int randomIndex = (int) (Math.random() * deckOfCards.size());
            shuffledDeck.add(deckOfCards.remove(randomIndex));
        }
        return deckOfCards = shuffledDeck;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}