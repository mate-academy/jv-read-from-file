package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    private static final String FILTER_WORDS = "[\\s\\p{Punct}]+";
    private static final String STARTING_CHAR = "w";

    public String[] readFromFile(String fileName) {
        try {
            String content = Files.readString(Paths.get(fileName));
            return Arrays.stream(content.toLowerCase().split(FILTER_WORDS))
                    .filter(word -> word.startsWith(STARTING_CHAR))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
