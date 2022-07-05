import java.util.ArrayList;

public class CardGame {

    ArrayList<Card> deckOfCards = new ArrayList<>();
    
    static {
        for (int i = 0; i < 3; i++) {
            String suit = "";

            switch (i) {
                case 0:
                    suit = "spade";
                    break;
                case 1:
                    suit = "club";
                    break;
                case 2:
                    suit = "diamond";
                    break;
                case 3:
                    suit = "heart";
                    break;
                default:
                    System.out.println("This should never happen");
            }
            for (int j = 0; j < 13; j++) {
                deckOfCards.add(new Card(suit, ""))
            }
        }
    }

}
