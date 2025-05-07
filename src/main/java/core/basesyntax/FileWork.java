package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Розбиваємо рядок на слова і видаляємо знаки пунктуації
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "")
                        .split("\\s+");
                for (String word : words) {
                    // Додаємо тільки слова, які починаються на "w"
                    if (word.startsWith("w")) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        // Перетворюємо список в масив і сортуємо
        String[] wordsArray = result.toArray(new String[0]);
        Arrays.sort(wordsArray);
        return wordsArray;
    }
}
