package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> filteredWordsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String cleanWord = word.replaceAll("[^a-zA-Z]", "");
                    if (!cleanWord.isEmpty() && cleanWord.toLowerCase().startsWith("w")) {
                        filteredWordsList.add(cleanWord.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
        String[] filteredWords = filteredWordsList.toArray(new String[0]);
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
