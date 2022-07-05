import java.util.Objects;

public class Snap extends CardGame {

    public static void main() {
        CardGame.shuffleDeck();
        String previousSymbol = "";

        boolean isActive = true;
        while (isActive) {
            Card currentCard = CardGame.dealCard();
            assert currentCard != null;
            printMessage(currentCard.toString());
            if (Objects.equals(currentCard.getSymbol(), previousSymbol)) {
                printMessage("Snap!");
                isActive = false;
            } else {
                previousSymbol = currentCard.getSymbol();
            }
        }

    }

}
