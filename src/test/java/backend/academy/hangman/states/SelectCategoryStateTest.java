package backend.academy.hangman.states;

import backend.academy.hangman.HiddenWord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SelectCategoryStateTest extends BaseStateTest {
    @Override
    protected BaseState createState() {
        return new SelectCategoryState(game);
    }

    @Test
    void testStateTransitionSelectDifficultyState() {
        game.validateInput(" ");
        assertInstanceOf(SelectDifficultyState.class, game.getState());
    }

    @Test
    void testStateTransitionSelectCategoryState() {
        game.validateInput("а");
        assertInstanceOf(SelectCategoryState.class, game.getState());
    }

    // проверка правильности выбора слова из списка
    @Test
    void testHiddenWordChoosen() {
        assertNull(game.getHiddenWord());
        game.validateInput(" ");
        assertInstanceOf(HiddenWord.class, game.getHiddenWord());
        assertNotEquals(null, game.getHiddenWord());
    }
}
