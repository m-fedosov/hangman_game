package backend.academy.hangman;

import java.util.Scanner;

public class GameRunner {
    private final Scanner scanner;
    private final HangmanGame game;

    public GameRunner(HangmanGame game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (!game.state().isGameOver()) {
            game.display();
            String input = scanner.nextLine();
            game.validateInput(input);
        }
        game.display();
        scanner.close();
    }
}
