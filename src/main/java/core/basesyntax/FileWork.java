package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        try {
            String content = Files.readString(Path.of(fileName));
            return Arrays.stream(content.split("[\\s\\p{Punct}]+"))
                    .map(String::toLowerCase)
                    .filter(s -> !s.isEmpty())
                    .filter(s -> s.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + fileName, e);
        }
    }

}
