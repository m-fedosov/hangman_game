package backend.academy.hangman;

public class WelcomeState extends State {
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
    }
}
