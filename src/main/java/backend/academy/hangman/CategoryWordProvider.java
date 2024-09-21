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
    private final Map<String, List<String>> categories;

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
            Map<String, List<String>> loadedCategories = objectMapper.readValue(inputStream, Map.class);
            categories.putAll(loadedCategories);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке категорий: " + e.getMessage());
            System.exit(1); // Остановка программы в случае ошибки
        }
    }

    public List<String> getCategories() {
        return new ArrayList<>(categories.keySet());
    }

    public String getRandomWordFromCategory(String category) {
        List<String> words = categories.getOrDefault(category, new ArrayList<>());
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
