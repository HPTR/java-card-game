import java.util.*;
import java.io.*;

public class Snap extends CardGame {

    private final Player playerOne;
    private final Player playerTwo;

    public Snap(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    private String str = "";
    private int turnCounter = 0;

    public void startTimer() throws IOException {
        Timer timer = new Timer();
        timer.schedule( task, 2*1000 );

        System.out.println();
        BufferedReader in = new BufferedReader(
                new InputStreamReader( System.in ) );
        str = in.readLine();
    }

    TimerTask task = new TimerTask() {
        public void run() {

        if (playerTwo == null) {
            if (str.equals("snap")) {
                System.out.println("\nSnap! You Win!");
            } else {
                System.out.println("\nYou lose!");
            }
        } else {
            String currentPlayer = turnCounter % 2 == 0 ? playerTwo.getName() : playerOne.getName();
            if (str.equals("snap")) {
                System.out.println("\nSnap! " + currentPlayer + " Wins!");
            } else {
                System.out.println("\n" + currentPlayer + " loses!");
            }
        }

        System.exit(0);
        }
    };

    public void getInput() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
    }

    public void onePlayer() throws IOException {
        CardGame.deckOfCards = CardGame.shuffleDeck();
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
                startTimer();
            }
            getInput();
        }
    }

    public void twoPlayer() throws IOException {
        CardGame.deckOfCards = CardGame.shuffleDeck();
        ArrayList<String> dealtCardSymbols = new ArrayList<>();
        dealtCardSymbols.add("0");
        boolean isActive = true;

        while (isActive) {
            Card currentCard = CardGame.dealCard();
            assert currentCard != null;
            dealtCardSymbols.add(currentCard.getSymbol());
            printMessage(currentCard.toString());

            if (Objects.equals(dealtCardSymbols.get(dealtCardSymbols.size() - 1), dealtCardSymbols.get(dealtCardSymbols.size() - 2))) {
                startTimer();
                isActive = false;
            }
            getInput();
            turnCounter++;
        }
    }
}
