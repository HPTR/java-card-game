import java.util.*;
import java.io.*;

public class Snap extends CardGame {

    static Timer timer = new Timer();

    public static void getInput() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
    }

    private static String str = "";
    private static boolean victory;

    public static boolean isVictory() {
        return victory;
    }

    public static void setVictory(boolean victory) {
        Snap.victory = victory;
    }

    static TimerTask task = new TimerTask() {
        public void run() {
            if (str.equals("snap")) {
                System.out.println("Snap! You Win!");
                setVictory(true);
            } else {
                System.out.println("You lose!");
                setVictory(false);
            }

            System.exit(0);
        }
    };

                       },
                3000
        );
    }
    //Need to solve that you need to press enter once a pair is there to trigger the timer...
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
                startTimer(player);
                isActive = false;
            } else {
                previousSymbol = currentCard.getSymbol();
            }
        }
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
