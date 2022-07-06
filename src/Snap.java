import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    static Timer timer = new Timer();

    public static void getInput() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
    }

    public static void onePlayer(Player player) {
        CardGame.shuffleDeck();
        String previousSymbol = "";
        boolean isActive = true;
        while (isActive) {
            Card currentCard = CardGame.dealCard();
            assert currentCard != null;
            printMessage(currentCard.toString());
            getInput();
            if (Objects.equals(currentCard.getSymbol(), previousSymbol)) {
                printMessage("Snap!\n");
                player.incrementScore();
                isActive = false;
            } else {
                previousSymbol = currentCard.getSymbol();
            }
        }
    }

    public static void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        })
    }

    public static void twoPlayer(Player playerOne, Player playerTwo) {
        CardGame.shuffleDeck();
        String previousSymbol = "";
        boolean isActive = true;
        int turnCounter = 1;
        while (isActive) {
            Card currentCard = CardGame.dealCard();
            assert currentCard != null;
            printMessage(currentCard.toString());
            if (Objects.equals(currentCard.getSymbol(), previousSymbol)) {
                printMessage("\nSnap!\n");

                if (turnCounter % 2 == 0) {
                    playerTwo.incrementScore();
                    printMessage(String.format("%s wins!", playerTwo.getName()));
                } else {
                    playerOne.incrementScore();
                    printMessage(String.format("%s wins!", playerOne.getName()));
                }

                isActive = false;
            } else {
                getInput();
                previousSymbol = currentCard.getSymbol();
                turnCounter += 1;
            }

        }

    }

}
