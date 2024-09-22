package backend.academy.hangman.states;

import backend.academy.hangman.HangmanGame;
import backend.academy.hangman.HiddenWord;
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
        game.attempts(2);
        game.hiddenWord(new HiddenWord(testWord));
        game.state(createState());
    }

    @Test
    void testStateTransitionGameOverStateWin() {
        for (int i = 0; i < testWord.length(); i++) {
            game.validateInput(String.valueOf(testWord.charAt(i)));
            if (game.isWin()) {
                break;
            }
        }
        assertNotEquals(0, game.attempts());
        assertTrue(game.isWin());
        assertInstanceOf(GameOverState.class, game.state());
    }

    @Test
    void testUpperCaseInput() {
        for (int i = 0; i < testWord.length(); i++) {
            game.validateInput(String.valueOf(testWord.charAt(i)).toUpperCase());
            if (game.isWin()) {
                break;
            }
        }
        assertNotEquals(0, game.attempts());
        assertTrue(game.isWin());
        assertInstanceOf(GameOverState.class, game.state());
    }

    @Test
    void testOneCharInputOnly() {
        int attemptsBeforeInput = game.attempts();
        game.validateInput(testWord);
        int attemptsAfterWrongInput = game.attempts();
        assertEquals(attemptsAfterWrongInput, attemptsBeforeInput);

        game.validateInput("й");
        int attemptsAfterWrongInput2 = game.attempts();
        assertNotEquals(attemptsAfterWrongInput2, attemptsBeforeInput);
    }

    @Test
    void testStateTransitionGameOverStateLose() {
        String incorrectLetters = "йцукен";
        for (int i = 0; i < incorrectLetters.length(); i++) {
            game.validateInput(String.valueOf(incorrectLetters.charAt(i)));
            if (game.attempts() == 0) {
                break;
            }
        }
        assertEquals(0, game.attempts());
        assertFalse(game.isWin());
        assertInstanceOf(GameOverState.class, game.state());
    }
}
