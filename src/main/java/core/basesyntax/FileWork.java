package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine().toLowerCase();
                for (String word : line.split(" ")) {
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (word.startsWith("w")) {
                        builder.append(word).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Помилка:" + e);
        }
        if (builder.isEmpty()) {
            return new String[0];
        }
        String[] correctWords = builder.toString().split(" ");
        Arrays.sort(correctWords);
        return correctWords;
    }
}
