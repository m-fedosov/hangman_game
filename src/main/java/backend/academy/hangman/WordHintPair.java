package backend.academy.hangman;

public class WordHintPair {
    private final String word;
    private final String hint;

    public WordHintPair(String word, String hint) {
        this.word = word;
        this.hint = hint;
    }

    public String getWord() {
        return word;
    }

    public String getHint() {
        return hint;
    }
}
