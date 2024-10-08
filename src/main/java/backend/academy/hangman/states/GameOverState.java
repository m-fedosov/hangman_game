package backend.academy.hangman.states;

import backend.academy.hangman.EasterEgg;
import backend.academy.hangman.HangmanGame;

public class GameOverState extends BaseState {
    public GameOverState(HangmanGame context) {
        super(context);
    }

    @Override
    public void display() {
        if (context.isWin()) {
            print("Игра закончена. Вы победили!");
            if (context.isEasterEggEnable()) {
                print(EasterEgg.getAsciiArt());
            }
        } else {
            print("Игра закончена. Вы проиграли :(");
            print("А ведь слово было простое: " + context.hiddenWord().word());
        }

    }

    @Override
    public void enterLetter(char letter) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
