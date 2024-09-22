package backend.academy.hangman;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        GameRunner gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
