public class Snap extends CardGame {

    public static void main() {
     CardGame.shuffleDeck();
     Card currentCard = CardGame.dealCard();
     String previousSymbol = currentCard.getSymbol();
     printMessage(currentCard.toString());
    }

}
