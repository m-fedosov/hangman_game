package backend.academy.hangman;

import java.util.ArrayList;

public class HiddenWord {
    private final String word;
    private final ArrayList<Integer> guessedLetters;

    public HiddenWord(String word) {
        this.word = word;
        guessedLetters = new ArrayList<>();
    }

    public String getWithGuessedLetters() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (guessedLetters.contains(i)) {
                stringBuilder.append(word.charAt(i));
            } else {
                stringBuilder.append('_');
            }
        }
        return stringBuilder.toString();
    }

    public boolean isWordGuessed() {
        for (int i = 0; i < word.length(); i++) {
            if (!guessedLetters.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkLetter(char letter) {
        boolean isRightLetter = false;
        for (int i = 0; i < word.length(); i++) {
            if (letter == word.charAt(i)) {
                guessedLetters.add(i);
                isRightLetter = true;
            }
        }
        return isRightLetter;
    }

    public String getWord() {
        return word;
    }
}
