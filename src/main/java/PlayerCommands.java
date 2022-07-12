public class PlayerCommands extends Commands {

    private Player player;
    public PlayerCommands() {
        super("Create Player", new String[]{}, "player");
    }
    public Player getUser() {
        return player;
    }

    @Override
    public void run() {
        printMessage("Enter player name");
        String name = getStringInput();

        player = new Player(name);

        setNextCommands("home");
    }
}
