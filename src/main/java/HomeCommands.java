public class HomeCommands extends Commands {
    public HomeCommands() {
        super("Home", new String[]{"One Player", "Two Player", "Quit" }, "home");
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        if (userInput == 1) {
            setNextCommands("onePlayer");
        } else if (userInput == 2) {
            setNextCommands("twoPlayer");
        } else {
            setNextCommands("");
        }
    }
}