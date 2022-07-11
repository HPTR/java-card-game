import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

            Commands currentCommands = new HomeCommands();
            currentCommands.run();

            switch(currentCommands.getNextCommands()){
                case "onePlayer" :
                    currentCommands = new PlayerCommands();
                    currentCommands.run();
                    Player player = ((PlayerCommands) currentCommands).getUser();

                    Snap.onePlayer(player);
                    break;

                case "twoPlayer" :
                    currentCommands = new PlayerCommands();
                    currentCommands.run();
                    Player playerOne = ((PlayerCommands) currentCommands).getUser();

                    currentCommands = new PlayerCommands();
                    currentCommands.run();
                    Player playerTwo = ((PlayerCommands) currentCommands).getUser();

                    Snap.twoPlayer(playerOne, playerTwo);
                    break;

                default:
                    System.exit(0);
            }
    }
}