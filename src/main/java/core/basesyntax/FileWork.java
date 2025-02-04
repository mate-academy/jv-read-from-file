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
                // Розділяємо рядок на слова, ігноруючи пунктуацію
                String[] words = line.toLowerCase().split("[^a-zA-Z]+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Повертаємо масив у природному (лексикографічному) порядку
        String[] sortedWords = result.toArray(new String[0]);
        Arrays.sort(sortedWords);
        return sortedWords;
    }
}
