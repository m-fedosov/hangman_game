package backend.academy.hangman.states;

import backend.academy.hangman.HangmanDrawing;
import backend.academy.hangman.HangmanGame;
import backend.academy.hangman.HiddenWord;
import java.util.HashSet;
import java.util.Set;

public class PlayState extends BaseState {
    private static final String VALID_CHARS_REGEX = "[а-яА-Я?]{1}";

    private final HangmanDrawing hangmanDrawing;
    private final HiddenWord hiddenWord;
    private final Set<Character> guessedLetters; // Хранение введённых букв

    public PlayState(HangmanGame context) {
        super(context);
        hiddenWord = context.hiddenWord();
        hangmanDrawing = new HangmanDrawing(context.attempts());
        guessedLetters = new HashSet<>();
    }

    @Override
    public void display() {
        print(hangmanDrawing.getArt());
        if (context.isHintUsed()) {
            print(context.hint());
        } else {
            print("введи \"?\" чтобы получить подсказку");
        }
        print(hiddenWord.getWithGuessedLetters());
        print("Осталось попыток: " + context.attempts());
    }

    @Override
    public void enterLetter(char letter) {
        if (letter == '?') {
            context.isHintUsed(true);
        } else if (guessedLetters.contains(letter)) {
            print("Эта буква уже была введена");
        } else {
            guessedLetters.add(letter);

            if (!hiddenWord.checkLetter(letter)) {
                context.attempts(context.attempts() - 1);
                hangmanDrawing.drawNextPart();
            }
            if (hiddenWord.isWordGuessed()) {
                display();
                context.isWin(true);
                context.state(new GameOverState(context));
            }
            if (context.attempts() <= 0) {
                display();
                context.isWin(false);
                context.state(new GameOverState(context));
            }
        }
    }

    @Override
    public void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            print("Пустой ввод запрещён.");
            return;
        }

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
