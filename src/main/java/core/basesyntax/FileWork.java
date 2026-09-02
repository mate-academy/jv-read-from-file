package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        if (fileName.isEmpty()) {
            return null;
        } else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                StringBuilder builder = new StringBuilder();
                int value = bufferedReader.read();
                while (value != -1) {
                    builder.append((char) value);
                    value = bufferedReader.read();
                }
                String fileContent = builder.toString();
                String[] words = fileContent.split("\\W+");
                String[] result = (String[]) Arrays.stream(words)
                        .map(String::toLowerCase)
                        .filter(word -> word.startsWith("w"))
                        .sorted().toArray(String[]::new);
                return result;
            } catch (IOException e) {
                throw new RuntimeException("Can't read file", e);
            }
        }
    }
}
