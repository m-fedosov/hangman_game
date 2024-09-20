package backend.academy.hangman.states;

import backend.academy.hangman.CategoryWordProvider;
import backend.academy.hangman.HangmanGame;
import java.util.Random;

public class SelectCategoryState extends BaseState {
    private final CategoryWordProvider categoryWordProvider;

    public SelectCategoryState(HangmanGame context) {
        super(context);
        this.categoryWordProvider = new CategoryWordProvider();
    }

    @Override
    public void display() {
        print("Выберите категорию:");
        int index = 1;
        for (String category : categoryWordProvider.getCategories()) {
            print(index + ". " + category);
            index++;
        }
        print("пробел - случайная категория");
    }

    @Override
    public void enterLetter(char letter) {
        int cntCategories = categoryWordProvider.getCategories().size();
        int categoryIndex;
        if (Character.isSpaceChar(letter)) {
            Random random = new Random();
            categoryIndex = random.nextInt(cntCategories) + 1;
        } else {
            categoryIndex = Character.getNumericValue(letter);
        }
        if (categoryIndex < 1 || categoryIndex > cntCategories) {
            print("Введите число от 1 до " + cntCategories);
            return;
        }

        String selectedCategory = categoryWordProvider.getCategories().get(categoryIndex - 1);
        print("Выбрана категория - " + selectedCategory);

        String hiddenWord = categoryWordProvider.getRandomWordFromCategory(selectedCategory);

        context.setHiddenWord(hiddenWord);
        context.setState(new SelectDifficultyState(context));
    }
}
