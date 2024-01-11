package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        try {
            String content = Files.readString(Paths.get(fileName));
            String cleanedContent = content.replaceAll("\\p{Punct}", "").toLowerCase();
            String[] words = cleanedContent.split("\\s+");
            return Arrays.stream(words)
                    .filter(word -> word.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from the file: " + e.getMessage(), e);
        }
    }
}
