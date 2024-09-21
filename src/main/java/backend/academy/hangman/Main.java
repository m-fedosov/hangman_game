package backend.academy.hangman;

public class Main {
    // Приватный конструктор для предотвращения создания экземпляров
    private Main() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        GameRunner gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
