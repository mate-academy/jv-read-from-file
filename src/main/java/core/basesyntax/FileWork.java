package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
        String text = content.toString().trim();
        String cleanedText = text.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
        String[] words = cleanedText.split("\\s+"); // Используем \\s+ для разделения по пробелам
        List<String> wordsStartingWithW = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty() && (word.charAt(0) == 'w' || word.charAt(0) == 'W')) {
                wordsStartingWithW.add(word);
            }
        }
        // Сортировка массива перед возвратом
        String[] sortedWords = wordsStartingWithW.toArray(new String[0]);
        Arrays.sort(sortedWords);
        return sortedWords;
    }
}