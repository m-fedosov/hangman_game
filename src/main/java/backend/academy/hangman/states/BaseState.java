package backend.academy.hangman.states;

import backend.academy.hangman.HangmanGame;
import backend.academy.hangman.InputValidator;

public abstract class BaseState {
    HangmanGame context;

    public BaseState(HangmanGame context) {
        this.context = context;
    }

    public abstract void display();

    public abstract void enterLetter(char letter);

    public void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            print("Пустой ввод запрещён.");
            return;
        }

        if (InputValidator.isValidInput(input)) {
            char letter = Character.toLowerCase(input.charAt(0));
            enterLetter(letter);
        } else {
            print("Введите только один символ (цифра/кириллица/пробел)");
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    void print(String text) {
        System.out.println(text);
    }

    public boolean isGameOver() {
        return false;
    }
}
