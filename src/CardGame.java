import java.util.ArrayList;

public class CardGame {

    static ArrayList<Card> deckOfCards = new ArrayList<>();
    
    static {
        for (int i = 0; i < 4; i++) {

            String[] suits = new String[] {"\u2664;", "\u2661", "\u2667", "\u2662"};

            for (int j = 0; j < 13; j++) {

                String[] symbols = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
                Integer[] values = new Integer[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

                deckOfCards.add(new Card(suits[i], symbols[j], values[j]));
            }
        }
    }

    public static void printCards() {
        for (Card card : deckOfCards) {
            System.out.println(card.toString());
        }
    }

}
