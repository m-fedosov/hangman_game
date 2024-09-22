package backend.academy.hangman.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class SelectDifficultyStateTest extends BaseStateTest {
    @Override
    protected BaseState createState() {
        return new SelectDifficultyState(game);
    }

    @Test
    void testStateTransitionSelectPlayState() {
        game.validateInput(" ");
        assertInstanceOf(PlayState.class, game.state());
    }

    @Test
    void testStateTransitionSelectDifficultyState() {
        game.validateInput("а");
        assertInstanceOf(SelectDifficultyState.class, game.state());
    }
}
