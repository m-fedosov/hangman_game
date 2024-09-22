package backend.academy.hangman.states;

import backend.academy.hangman.DifficultyManager;
import backend.academy.hangman.HangmanGame;
import java.util.Random;

public class SelectDifficultyState extends BaseState {
    private final DifficultyManager difficultyManager;

    public SelectDifficultyState(HangmanGame context) {
        super(context);
        difficultyManager = new DifficultyManager();
    }

    @Override
    public void display() {
        print("Выберите сложность:");
        int index = 1;
        for (String category : difficultyManager.getDifficultiesNames()) {
            print(index + ". " + category);
            index++;
        }
        print("пробел - случайная сложность");
    }

    @Override
    public void enterLetter(char letter) {
        int cntDifficulties = difficultyManager.getDifficultiesNames().size();
        int difficultyIndex;
        if (Character.isSpaceChar(letter)) {
            Random random = new Random();
            difficultyIndex = random.nextInt(cntDifficulties) + 1;
        } else {
            difficultyIndex = Character.getNumericValue(letter);
        }
        if (difficultyIndex < 1 || difficultyIndex > cntDifficulties) {
            print("Введите число от 1 до " + cntDifficulties);
            return;
        }

        String selectedDifficulty = difficultyManager.getDifficultiesNames().get(difficultyIndex - 1);
        print("Выбрана сложность - " + selectedDifficulty);

        Integer attempts = difficultyManager.getDifficultyAttempts(selectedDifficulty);
        print("Количество попыток - " + attempts);

        if (attempts == 1) {
            context.setEasterEggEnable(true);
        }

        context.setAttempts(attempts);
        context.setState(new PlayState(context));
    }
}
