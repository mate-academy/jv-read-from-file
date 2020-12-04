package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    private static final String START_SYMBOL = "w";

    public static String[] readFromFile(String fileName) {
        try {
            return Files.readAllLines(new File(fileName).toPath())
                    .stream()
                    .flatMap(line -> Arrays.stream((line + " ").toLowerCase().split("[.!?]* ")))
                    .filter(word -> word.startsWith(START_SYMBOL))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Could not read from file " + fileName, e);
        }
    }
}
