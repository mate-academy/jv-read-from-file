package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private static final String TARGET_LETTER = "w";
    private static final String WORD_SPLIT_REGEX = "\\W+"; // Визначаємо роздільник слів

    public String[] readFromFile(String fileName) {
        List<String> wordsList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase().split(WORD_SPLIT_REGEX);

                for (String word : words) {
                    if (!word.isEmpty() && word.startsWith(TARGET_LETTER)) {
                        wordsList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Помилка читання файлу: " + fileName, e);
        }

        wordsList.sort(String::compareTo); // Сортуємо список алфавітно
        return wordsList.toArray(new String[0]);
    }
}
