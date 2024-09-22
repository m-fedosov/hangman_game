package backend.academy.hangman.states;

import backend.academy.hangman.HangmanGame;

public class WelcomeState extends BaseState {
    public WelcomeState(HangmanGame context) {
        super(context);
    }

    @Override
    public void display() {
        String displayText = """
                ----------------------
                       Виселица!
                ----------------------
                @design by Mikhail Fedosov

                Пробел - начать игру
                Другую клавишу - показать правила
                """;
        print(displayText);
    }

    @Override
    public void enterLetter(char letter) {
        if (Character.isSpaceChar(letter)) {
            context.state(new SelectCategoryState(context));
        } else {
            context.state(new RulesState(context));
        }
    }
}
