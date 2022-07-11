import java.util.*;
import java.io.*;

public class Snap extends CardGame {


    static Timer timer = new Timer();
    private static String str = "";

    public static void startTimer(Player player) throws IOException {
        Timer timer = new Timer();
        timer.schedule( task, 2*1000 );

        System.out.println("");
        BufferedReader in = new BufferedReader(
                new InputStreamReader( System.in ) );
        str = in.readLine();
    }

    static TimerTask task = new TimerTask() {
        public void run() {
            if (str.equals("snap")) {
                System.out.println("Snap! You Win!");
            } else {
                System.out.println("You lose!");
            }

            System.exit(0);
        }
    };

    public static void getInput() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
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

    public static void twoPlayer(Player playerOne, Player playerTwo) throws IOException {
        CardGame.shuffleDeck();
        ArrayList<String> dealtCardSymbols = new ArrayList<>();
        dealtCardSymbols.add("B");
        boolean isActive = true;
        int turnCounter = 1;

        while (isActive) {
            Card currentCard = CardGame.dealCard();
            assert currentCard != null;
            dealtCardSymbols.add(currentCard.getSymbol());
            printMessage(currentCard.toString());

            if (Objects.equals(dealtCardSymbols.get(dealtCardSymbols.size() - 1), dealtCardSymbols.get(dealtCardSymbols.size() - 2))) {
                isActive = false;
                startTimer(playerTwo);

                if (turnCounter % 2 == 0) {
                    printMessage(playerTwo.toString() + " - ");
                } else {
                    printMessage(playerOne.toString() + " - ");
                }

                isActive = false;
            }
            getInput();
            turnCounter++;
        }
    }
}
