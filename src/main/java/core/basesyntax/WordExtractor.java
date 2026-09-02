package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class WordExtractor {
    public String[] readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + fileName, e);
        }

        String[] words = content.toString().toLowerCase().split("[\\s\\p{Punct}]+");

        return Arrays.stream(words)
                .filter(word -> word.startsWith("w"))
                .sorted().toArray(String[]::new);
    }
}
