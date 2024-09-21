package backend.academy.hangman;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CategoryWordProvider {
    private final Map<String, List<WordHintPair>> categories;

    public CategoryWordProvider() {
        categories = new HashMap<>();
        String fileName = "categories.json";
        loadCategoriesFromJson(fileName);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private void loadCategoriesFromJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName))  {
            // Чтение JSON в строку
            Map<String, List<Map<String, String>>> loadedCategories = objectMapper.readValue(inputStream, Map.class);
            for (Map.Entry<String, List<Map<String, String>>> entry : loadedCategories.entrySet()) {
                List<WordHintPair> wordHintPairs = new ArrayList<>();
                for (Map<String, String> wordHintMap : entry.getValue()) {
                    String word = wordHintMap.get("слово");
                    String hint = wordHintMap.get("подсказка");
                    wordHintPairs.add(new WordHintPair(word, hint));
                }
                categories.put(entry.getKey(), wordHintPairs);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке категорий: " + e.getMessage());
            System.exit(1); // Остановка программы в случае ошибки
        }
    }

    public List<String> getCategories() {
        return new ArrayList<>(categories.keySet());
    }

    public WordHintPair getRandomWordHintPairFromCategory(String category) {
        List<WordHintPair> words = categories.getOrDefault(category, new ArrayList<>());
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
