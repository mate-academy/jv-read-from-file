package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder dataBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();
            while (value != -1) {
                dataBuilder.append((char) value);
                value = reader.read();
            }
            String[] words = dataBuilder.toString().toLowerCase()
                    .replaceAll("[./,!?]", "")
                    .split("\\s+");

            StringBuilder resultBuilder = new StringBuilder();
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    resultBuilder.append(word).append(",");
                }
            }
            String[] filteredWords = resultBuilder.toString().split(",");
            if (filteredWords.length > 0 && !filteredWords[0].isEmpty()) {
                Arrays.sort(filteredWords);
                return filteredWords;
            } else {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + fileName, e);
        }
    }
}
