package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String WORDS_SEPARATOR = "\\W+";
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            for (String line : lines) {
                String[] words = line.split(WORDS_SEPARATOR);
                for (String word : words) {
                    String currentWord = word.toLowerCase();
                    if (currentWord.startsWith(FIRST_LETTER)) {
                        stringBuilder.append(currentWord).append(" ");
                    }
                }
            }

            if (stringBuilder.isEmpty()) {
                return new String[0];
            }

            String[] result = stringBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
    }
}
