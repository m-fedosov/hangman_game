package backend.academy.hangman;

import backend.academy.hangman.states.GameOverState;
import java.util.Scanner;

public class Main {
    // Приватный конструктор для предотвращения создания экземпляров
    private Main() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanGame game = new HangmanGame();

        while (!(game.getState() instanceof GameOverState)) {
            game.display();
            String input = scanner.nextLine();
            game.validateInput(input);
        }

        game.display();
        scanner.close();
    }
}
