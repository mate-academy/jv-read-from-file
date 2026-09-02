package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> filteredWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Видаляємо розділові знаки і розбиваємо текст на слова
                String[] words = line.replaceAll("[^a-zA-Z ]", "").split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                        filteredWords.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }

        Collections.sort(filteredWords);

        return filteredWords.toArray(new String[0]);
    }
}
