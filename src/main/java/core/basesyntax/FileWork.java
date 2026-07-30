package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String WORD_SEPARATOR_REGEX = "[\\s\\p{Punct}]+";
    private static final String REQUIRED_FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            return Arrays.stream(Files.readString(Path.of(fileName)).split(WORD_SEPARATOR_REGEX))
                    .map(word -> word.toLowerCase(Locale.ROOT))
                    .filter(word -> word.startsWith(REQUIRED_FIRST_LETTER))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }
}
