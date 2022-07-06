public class Player {
    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score <= 100 && score >= 0) {
            this.score = score;
        }
    }

    @Override
    public String toString() {
        return String.format("\nName : %s \nScore : %s \n", this.name, this.score);
    }

    public void incrementScore() {
        setScore(score + 1);
    }
}
