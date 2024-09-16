package backend.academy.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DifficultyManager {
    private Map<String, Integer> difficulties;

    public DifficultyManager() {
        initDifficulties();
    }

    @SuppressWarnings("MagicNumber")
    public void initDifficulties() {
        difficulties = new TreeMap<>();
        difficulties.put("Карапуз", 10);
        difficulties.put("Без напряга", 8);
        difficulties.put("Норм", 6);
        difficulties.put("Реальный хардкор", 4);
        difficulties.put("Это было не то что смело, это было жесть как смело", 1);
    }

    public List<String> getDifficultiesNames() {
        return new ArrayList<>(difficulties.keySet());
    }

    public Integer getDifficultyAttempts(String difficulty) {
        return difficulties.get(difficulty);
    }
}
