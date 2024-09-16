package backend.academy.hangman.states;

import backend.academy.hangman.HangmanGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayStateTest extends BaseStateTest {
    private final String testWord = "база";

    @Override
    protected BaseState createState() {
        return new PlayState(game);
    }

    @Override
    @BeforeEach
    void setUp() {
        game = new HangmanGame();
        game.setAttempts(2);
        game.setHiddenWord(testWord);
        game.setState(createState());
    }

    @Test
    void testStateTransitionGameOverStateWin() {
        for (int i = 0; i < testWord.length(); i++) {
            game.validateInput(String.valueOf(testWord.charAt(i)));
            if (game.isWin()) {
                break;
            }
        }
        assertNotEquals(0, game.getAttempts());
        assertTrue(game.isWin());
        assertInstanceOf(GameOverState.class, game.getState());
    }

    @Test
    void testUpperCaseInput() {
        for (int i = 0; i < testWord.length(); i++) {
            game.validateInput(String.valueOf(testWord.charAt(i)).toUpperCase());
            if (game.isWin()) {
                break;
            }
        }
        assertNotEquals(0, game.getAttempts());
        assertTrue(game.isWin());
        assertInstanceOf(GameOverState.class, game.getState());
    }

    @Test
    void testOneCharInputOnly() {
        int attemptsBeforeInput = game.getAttempts();
        game.validateInput(testWord);
        int attemptsAfterWrongInput = game.getAttempts();
        assertEquals(attemptsAfterWrongInput, attemptsBeforeInput);

        game.validateInput("й");
        int attemptsAfterWrongInput2 = game.getAttempts();
        assertNotEquals(attemptsAfterWrongInput2, attemptsBeforeInput);
    }

    @Test
    void testStateTransitionGameOverStateLose() {
        String incorrectLetters = "йцукен";
        for (int i = 0; i < incorrectLetters.length(); i++) {
            game.validateInput(String.valueOf(incorrectLetters.charAt(i)));
            if (game.getAttempts() == 0) {
                break;
            }
        }
        assertEquals(0, game.getAttempts());
        assertFalse(game.isWin());
        assertInstanceOf(GameOverState.class, game.getState());
    }
}
