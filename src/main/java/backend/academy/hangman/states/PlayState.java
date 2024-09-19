package backend.academy.hangman.states;

import backend.academy.hangman.HangmanDrawing;
import backend.academy.hangman.HangmanGame;
import backend.academy.hangman.HiddenWord;

public class PlayState extends BaseState {
    private static final String VALID_CHARS_REGEX = "[а-яА-Я]{1}";

    private final HangmanDrawing hangmanDrawing;
    private final HiddenWord hiddenWord;

    public PlayState(HangmanGame context) {
        super(context);
        hiddenWord = context.getHiddenWord();
        hangmanDrawing = new HangmanDrawing(context.getAttempts());
    }

    @Override
    public void display() {
        print(hangmanDrawing.getArt());
        print(hiddenWord.getWithGuessedLetters());
        print("Осталось попыток: " + context.getAttempts());
    }

    @Override
    public void enterLetter(char letter) {
        if (!hiddenWord.checkLetter(letter)) {
            context.setAttempts(context.getAttempts() - 1);
            hangmanDrawing.drawNextPart();
        }
        if (hiddenWord.isWordGuessed()) {
            display();
            context.setWin(true);
            context.setState(new GameOverState(context));
        }
        if (context.getAttempts() == 0) {
            display();
            context.setWin(false);
            context.setState(new GameOverState(context));
        }
    }

    @Override
    public void validateInput(String input) {
        if (isValidInput(input)) {
            char letter = Character.toLowerCase(input.charAt(0));
            enterLetter(letter);
        } else {
            print("Введите только один символ кириллицы");
        }
    }

    private static boolean isValidInput(String input) {
        return input.matches(VALID_CHARS_REGEX);
    }
}
