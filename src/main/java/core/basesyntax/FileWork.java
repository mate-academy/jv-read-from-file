package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    private static final Pattern PATTERN_SEPARATOR = Pattern.compile("\\W+");
    private static final String STARTING_WITH_CHAR_LOWER = "w";
    private static final String STARTING_WITH_CHAR_UPPER = STARTING_WITH_CHAR_LOWER.toUpperCase();

    public String[] readFromFile(String fileName) {
        try {
            return Arrays.stream(PATTERN_SEPARATOR.split(
                    String.join(System.lineSeparator(),
                            Files.readAllLines(new File(fileName).toPath()))))
                    .filter(word -> {
                        if (word == null || word.isEmpty()) {
                            return false;
                        }
                        return word.startsWith(STARTING_WITH_CHAR_LOWER)
                                || word.startsWith(STARTING_WITH_CHAR_UPPER);
                    })
                    .map(String::toLowerCase)
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + fileName, e);
        }
    }
}
