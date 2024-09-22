package backend.academy.hangman;

import backend.academy.hangman.states.BaseState;
import backend.academy.hangman.states.WelcomeState;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HangmanGame {
    private BaseState state;
    private HiddenWord hiddenWord;
    private int attempts;
    private boolean isWin = false;
    private String hint;
    private boolean isHintUsed = false;
    private boolean isEasterEggEnable = false;

    public HangmanGame() {
        state(new WelcomeState(this));
    }

    public void display() {
        state.display();
    }

    public void validateInput(String input) {
        state.validateInput(input);
    }
}
