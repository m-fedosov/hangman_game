package backend.academy.hangman.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class WelcomeStateTest extends BaseStateTest {
    @Override
    protected BaseState createState() {
        return new WelcomeState(game);
    }

    @Test
    void testStateTransitionSelectCategoryState() {
        game.validateInput(" ");
        assertInstanceOf(SelectCategoryState.class, game.getState());
    }

    @Test
    void testStateTransitionRulesState() {
        game.validateInput("а");
        assertInstanceOf(RulesState.class, game.getState());
    }
}
