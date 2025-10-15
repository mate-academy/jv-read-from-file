package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = Files.readString(Paths.get(fileName));

            String[] words = content.split("[^a-zA-Z]+");

            String[] result = Arrays.stream(words)
                    .filter(word -> !word.isEmpty())
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);

            return result;

        } catch (IOException e) {
            return new String[0];
        }
    }
}
