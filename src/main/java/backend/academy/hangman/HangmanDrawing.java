package backend.academy.hangman;

public class HangmanDrawing {
    private int attemptsRemains;
    private final int maxAttempts;

    public HangmanDrawing(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.attemptsRemains = maxAttempts;
    }

    @SuppressWarnings({"MagicNumber", "MultipleStringLiterals"})
    public String getArt() {
        StringBuilder drawing = new StringBuilder();

        // 1. Рисуем верхнюю часть виселицы
        drawing.append("   _______\n");
        drawing.append("  |/      |\n");

        // 2. Рисуем столбец виселицы и веревку
        for (int i = 0; i < maxAttempts - attemptsRemains && i < 3; i++) {
            drawing.append("  |       |\n");  // Рисуем веревку
        }

        // Пустое пространство до начала веревки
        drawing.append("  |       \n".repeat(Math.max(0, attemptsRemains - 3)));

        // 3. Рисуем голову, тело и ноги человечка по мере уменьшения попыток
        String head = attemptsRemains <= 2 ? "(_)" : "   ";
        String body = attemptsRemains <= 1 ? "\\-|-/" : "     ";
        String legs = attemptsRemains == 0 ? "/ \\" : "   ";

        drawing.append(String.format("  |      %s\n", head));
        drawing.append(String.format("  |     %s\n", body));
        drawing.append(String.format("  |      %s\n", legs));

        // 4. Рисуем нижнюю часть виселицы
        drawing.append("  |\n");
        drawing.append(" _|_\n");
        drawing.append("|   |________\n");
        drawing.append("|____________|\n");

        return drawing.toString();
    }

    public void drawNextPart() {
        if (attemptsRemains == 0) {
            return;
        }
        attemptsRemains -= 1;
    }
}
