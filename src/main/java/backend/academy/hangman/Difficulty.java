package backend.academy.hangman;

public enum Difficulty {
    EASY("Карапуз", 10),
    MEDIUM("Без напряга", 8),
    NORMAL("Норм", 6),
    HARD("Реальный хардкор", 4),
    INSANE("Это было не то что смело, это было жесть как смело", 1);

    private final String name;
    private final int attempts;

    Difficulty(String name, int attempts) {
        this.name = name;
        this.attempts = attempts;
    }

    public String getName() {
        return name;
    }

    public int getAttempts() {
        return attempts;
    }
}
