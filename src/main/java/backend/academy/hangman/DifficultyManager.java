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

    public void initDifficulties() {
        difficulties = new TreeMap<>();
        for (Difficulty difficulty : Difficulty.values()) {
            difficulties.put(difficulty.getName(), difficulty.getAttempts());
        }
    }

    public List<String> getDifficultiesNames() {
        return new ArrayList<>(difficulties.keySet());
    }

    public Integer getDifficultyAttempts(String difficulty) {
        return difficulties.get(difficulty);
    }
}
