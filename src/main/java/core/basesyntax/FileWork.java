package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = Files.readString(Path.of(fileName));
            return Arrays.stream(content.split("[\\s\\p{Punct}]+"))
                    .map(word -> word.toLowerCase(Locale.ROOT))
                    .filter(word -> word.startsWith("w"))
                    .sorted().toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }
}
