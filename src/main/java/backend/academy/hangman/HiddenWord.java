package backend.academy.hangman;

import java.util.Arrays;
import lombok.Getter;

public class HiddenWord {
    @Getter private final String word;
    private final char[] revealedLetters;

    public HiddenWord(String word) {
        this.word = word;
        revealedLetters = new char[word.length()];
        Arrays.fill(revealedLetters, '_');
    }

    public String getWithGuessedLetters() {
        return new String(revealedLetters);
    }

    public boolean isWordGuessed() {
        for (char c : revealedLetters) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public boolean checkLetter(char letter) {
        boolean isRightLetter = false;
        for (int i = 0; i < word.length(); i++) {
            if (letter == word.charAt(i) && revealedLetters[i] == '_') {
                revealedLetters[i] = letter;
                isRightLetter = true;
            }
        }
        return isRightLetter;
    }

}
