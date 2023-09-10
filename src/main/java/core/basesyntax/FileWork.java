package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(Files.readString(Path.of(fileName)).toLowerCase());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        StringBuilder resultBuilder = new StringBuilder();
        String[] words = stringBuilder.toString().split("\\W+");
        Arrays.sort(words);
        for (String word : words) {
            if (word.startsWith("w")) {
                resultBuilder.append(word).append(" ");
            }
        }
        if (resultBuilder.toString().isEmpty()) {
            return new String[0];
        }
        return resultBuilder.toString().split(" ");
    }
}
