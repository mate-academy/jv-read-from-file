package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String STARTS_WITH = "w";

    public String[] readFromFile(String fileName) {
        Path path = Path.of(fileName);
        try {
            List<String> dataFromFile = Files.readAllLines(path);
            if (!dataFromFile.isEmpty()) {
                String[] words = dataFromFile.toString().toLowerCase().split("\\W+");
                StringBuilder builder = new StringBuilder();
                for (String word : words) {
                    if (word.startsWith(STARTS_WITH)) {
                        builder.append(word).append(" ");
                    }
                }

                if (builder.isEmpty()) {
                    return new String[0];
                }

                String[] sortedWords = builder.toString().split(" ");
                Arrays.sort(sortedWords);

                return sortedWords;
            } else {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
