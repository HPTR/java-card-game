public class Main {
    public static void main(String[] args) {

        Commands currentCommands = new HomeCommands();
        currentCommands.run();

        boolean isActive = true;
        while(isActive){
            switch(currentCommands.getNextCommands()){
                case "onePlayer" :
                    currentCommands = new PlayerCommands();
                    currentCommands.run();
                    Player player = ((PlayerCommands) currentCommands).getUser();

                    Snap.onePlayer(player);
                    CardGame.printMessage(player.toString());
                    break;

                case "twoPlayer" :
                    currentCommands = new PlayerCommands();
                    currentCommands.run();
                    Player playerOne = ((PlayerCommands) currentCommands).getUser();

                    currentCommands = new PlayerCommands();
                    currentCommands.run();
                    Player playerTwo = ((PlayerCommands) currentCommands).getUser();

                    Snap.twoPlayer(playerOne, playerTwo);
                    CardGame.printMessage(playerOne.toString());
                    CardGame.printMessage(playerTwo.toString());
                    break;

                default:
                    isActive = false;
            }
        }
    }
}