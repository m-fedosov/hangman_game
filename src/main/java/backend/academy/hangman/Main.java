package backend.academy.hangman;

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
            game.enterLetter(input.charAt(0));
        }

        game.display();
        scanner.close();
    }
}
