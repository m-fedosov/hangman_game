package backend.academy.hangman;

public abstract class State {
    HangmanGame context;

    public State(HangmanGame context) {
        this.context = context;
    }

    public abstract void display();

    public abstract void enterLetter(char letter);

    @SuppressWarnings("RegexpSinglelineJava")
    void print(String text) {
        System.out.println(text);
    }
}
