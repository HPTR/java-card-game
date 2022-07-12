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

                Snap snapGame = new Snap(player, null);
                snapGame.onePlayer();
                break;

            case "twoPlayer" :
                currentCommands = new PlayerCommands();
                currentCommands.run();
                Player playerOne = ((PlayerCommands) currentCommands).getUser();

                currentCommands = new PlayerCommands();
                currentCommands.run();
                Player playerTwo = ((PlayerCommands) currentCommands).getUser();

                snapGame = new Snap(playerOne, playerTwo);
                snapGame.twoPlayer();
                break;

            default:
                System.exit(0);
        }
    }
}