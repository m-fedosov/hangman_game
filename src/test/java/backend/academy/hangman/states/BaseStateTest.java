package backend.academy.hangman.states;

import backend.academy.hangman.HangmanGame;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseStateTest {

    protected HangmanGame game;

    @BeforeEach
    void setUp() {
        game = new HangmanGame();
        game.setState(createState());
    }

    protected abstract BaseState createState();
}
