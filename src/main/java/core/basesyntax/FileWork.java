package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {

    private final char LOWER_W_ASCII_VALUE = 119;
    private final char UPPER_W_ASCII_VALUE = 87;

    public String[] readFromFile(String fileName) {
        String s;
        try {
            s = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Problem with file reading");
        }

        return Arrays.stream(s.split("[ .,'\n;!?]"))
                .filter(item -> !item.isBlank())
                .filter(item -> item.charAt(0) == LOWER_W_ASCII_VALUE || item.charAt(0) == UPPER_W_ASCII_VALUE)
                .map(String::toLowerCase)
                .sorted()
                .toArray(String[]::new);
    }
}