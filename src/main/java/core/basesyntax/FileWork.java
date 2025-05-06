package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder buildString = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            if (value == -1) {
                return new String[0];
            }
            while (value != -1) {
                buildString.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] splitedWords = buildString.toString().toLowerCase().split("\\W+");
        Arrays.sort(splitedWords);
        StringBuilder buildFilteredWords = new StringBuilder();
        for (String word : splitedWords) {
            if (word.startsWith("w")) {
                buildFilteredWords.append(word).append(" ");
            }
        }
        if (buildFilteredWords.toString().isEmpty()) {
            return new String[0];
        }

        return buildFilteredWords.toString().split(" ");
    }
}
