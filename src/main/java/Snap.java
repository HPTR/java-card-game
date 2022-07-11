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

    public static void startTimer(Player player) throws IOException {
        Timer timer = new Timer();
        timer.schedule( task, 2*1000 );

        System.out.println("");
        BufferedReader in = new BufferedReader(
                new InputStreamReader( System.in ) );
        str = in.readLine();
    }

    public static void onePlayer(Player player) throws IOException {
        CardGame.shuffleDeck();
        ArrayList<String> dealtCardSymbols = new ArrayList<>();
        dealtCardSymbols.add("B");
        boolean isActive = true;

        while (isActive) {
            Card currentCard = CardGame.dealCard();
            assert currentCard != null;
            dealtCardSymbols.add(currentCard.getSymbol());
            printMessage(currentCard.toString());

            if (Objects.equals(dealtCardSymbols.get(dealtCardSymbols.size() - 1), dealtCardSymbols.get(dealtCardSymbols.size() - 2))) {
                isActive = false;
                startTimer(player);
            }
            getInput();
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
