package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        char targetLetter = 'w';
        StringBuilder wordsToSort = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Читаємо файл рядок за рядком
            while ((line = reader.readLine()) != null) {
                // Розбиваємо рядок на слова, очищаючи від небажаних символів
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Очищення слова від спеціальних символів і перевірка на початкову літеру
                    word = word.toLowerCase().replaceAll("[^a-z]", "");
                    if (word.startsWith(String.valueOf(targetLetter))) {
                        wordsToSort.append(word).append(" ");
                    }
                }
            }

            // Якщо не знайдено жодного слова, повертаємо порожній масив
            if (wordsToSort.length() == 0) {
                return new String[0];
            }

            // Розбиваємо слова на масив, сортуємо їх і повертаємо
            String[] filteredWords = wordsToSort.toString().trim().split("\\s+");
            Arrays.sort(filteredWords);
            return filteredWords;

        } catch (IOException e) {
            throw new RuntimeException("Помилка читання файлу: " + fileName, e);
        }
    }
}
