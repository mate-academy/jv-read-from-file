package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            String content = Files.readString(Paths.get(fileName));
            String[] split = content.toLowerCase(Locale.ROOT).split("\\W+");
            String[] strings = Arrays.stream(split)
                    .filter(s -> s.startsWith(SPECIFIED_CHARACTER))
                    .sorted()
                    .toArray(String[]::new);
            return strings;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file");
        }
    }
}
