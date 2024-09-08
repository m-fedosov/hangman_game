package backend.academy.hangman;

public class HangmanGame {
    private State state;

    public HangmanGame() {
        setState(new WelcomeState(this));
    }

    public void display() {
        state.display();
    }

    public void enterLetter(char letter) {
        state.enterLetter(letter);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
