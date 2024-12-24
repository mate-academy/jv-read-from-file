package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {

    private final char lowerWAsciiValue = 119;
    private final char upperWAsciiValue = 87;

    public String[] readFromFile(String fileName) {
        String line;
        try {
            line = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Problem with file reading");
        }

        return Arrays.stream(line.split("[ .,'\n;!?]"))
                .filter(item -> !item.isBlank())
                .filter(item -> item.charAt(0) == lowerWAsciiValue
                        || item.charAt(0) == upperWAsciiValue)
                .map(String::toLowerCase)
                .sorted()
                .toArray(String[]::new);
    }
}
