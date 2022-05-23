package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line == null) {
                return new String[0];
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                while (line != null) {
                    String[] words = line.split("\\W+");
                    for (String word : words) {
                        if (word.startsWith("W") || word.startsWith("w")) {
                            stringBuilder.append(word.toLowerCase()).append(" ");
                        }
                    }
                    line = reader.readLine();
                }
                String[] requiredWords = stringBuilder.toString().split(" ");
                Arrays.sort(requiredWords);
                return stringBuilder.toString().isEmpty() ? new String[0] : requiredWords;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
