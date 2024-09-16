package backend.academy.hangman.states;

import backend.academy.hangman.HangmanGame;

public class RulesState extends BaseState {
    public RulesState(HangmanGame context) {
        super(context);
    }

    @Override
    public void display() {
        String displayText = """
            Правила игры "Виселица":

            1. Цель игры: Угадать загаданное слово, вводя буквы по одной.

            2. Как играть:
               - Выберить категорию слов, или случайную категорию.
               - Выберите уровень сложности, чтобы начать игру.
               - Вводите буквы по одной.
               - Если буква есть в слове — она откроется. Если нет — добавится часть виселицы.

            3. Победа и поражение:
               - Выиграйте, угадав все буквы до завершения виселицы.
               - Проиграете, если виселица будет полностью нарисована.

            Удачи!

            Нажмите пробел, чтобы продолжить
            """;
        print(displayText);
    }

    @Override
    public void enterLetter(char letter) {
        if (Character.isSpaceChar(letter)) {
            context.setState(new SelectCategoryState(context));
        }
    }
}
