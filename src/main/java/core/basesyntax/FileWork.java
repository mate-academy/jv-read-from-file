package core.basesyntax;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    private static final String WORDS_START = "w";

    public static String[] readFromFile(String fileName) {
        try {
            return Arrays.stream(Files.readString(Paths.get(fileName), UTF_8)
                    .toLowerCase()
                    .split("\\W"))
                    .filter(x -> x.startsWith(WORDS_START))
                    .sorted()
                    .toArray(String[]::new);
        } catch (Exception e) {
            return null;
        }

    }
}
