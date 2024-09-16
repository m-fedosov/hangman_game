package backend.academy.hangman;

import backend.academy.hangman.states.BaseState;
import backend.academy.hangman.states.WelcomeState;

public class HangmanGame {
    private BaseState state;
    private HiddenWord hiddenWord;
    private int attempts;
    private boolean isWin = false;

    public HangmanGame() {
        setState(new WelcomeState(this));
    }

    public void display() {
        state.display();
    }

    public void validateInput(String input) {
        state.validateInput(input);
    }

    public void setState(BaseState state) {
        this.state = state;
    }

    public BaseState getState() {
        return state;
    }

    public void setHiddenWord(String word) {
        this.hiddenWord = new HiddenWord(word);
    }

    public HiddenWord getHiddenWord() {
        return hiddenWord;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}
