package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String text = Files.readString(Path.of(fileName));
            return Arrays.stream(text.split("[\\s\\p{Punct}]+"))
                    .map(String::toLowerCase)
                    .filter(word -> !word.isEmpty() && word.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            return new String[0];
        }
    }
}
