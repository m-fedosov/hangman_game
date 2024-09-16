package backend.academy.hangman;

public class InputValidator {
    // в вводе разрешён 1 символ из списка (пробел, киррилиица)
    private static final String VALID_CHARS_REGEX = "[0-9а-яА-Я ]{1}";

    // Приватный конструктор для предотвращения создания экземпляров
    private InputValidator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static boolean isValidInput(String input) {
        return input.matches(VALID_CHARS_REGEX);
    }

}
