package backend.academy.hangman.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class RulesStateTest extends BaseStateTest {
    @Override
    protected BaseState createState() {
        return new RulesState(game);
    }

    @Test
    void testStateTransitionSelectCategoryState() {
        game.validateInput(" ");
        assertInstanceOf(SelectCategoryState.class, game.getState());
    }

    @Test
    void testStateTransitionRulesState() {
        game.validateInput("a");
        assertInstanceOf(RulesState.class, game.getState());
    }
}
