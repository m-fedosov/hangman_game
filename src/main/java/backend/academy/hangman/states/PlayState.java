package backend.academy.hangman.states;

import backend.academy.hangman.HangmanDrawing;
import backend.academy.hangman.HangmanGame;
import backend.academy.hangman.HiddenWord;

public class PlayState extends BaseState {
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
}
