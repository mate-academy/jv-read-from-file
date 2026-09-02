package core.basesyntax;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();

        try {
            for (String line : Files.readAllLines(Path.of(fileName), StandardCharsets.UTF_8)) {
                String cleanedContent = line.replaceAll("[^\\w\\s]", "").toLowerCase();
                String[] words = cleanedContent.split("\\s+");

                for (String word : words) {
                    if (word.startsWith("w")) {
                        builder.append(word).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + e);
        }

        String filteredContent = builder.toString().trim();

        if (filteredContent.isEmpty()) {
            return new String[0];
        }

        String[] result = filteredContent.split("\\s+");
        Arrays.sort(result);
        return result;
    }
}
