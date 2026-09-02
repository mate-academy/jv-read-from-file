package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static final int FIRST_CHAR_INDEX = 0;
    public static final String NO_PUNCTUATION_REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> text = Files.readAllLines(Path.of(fileName));
            for (String sentence : text) {
                String[] words = sentence.toLowerCase().split(NO_PUNCTUATION_REGEX);
                for (String word : words) {
                    if (word.charAt(FIRST_CHAR_INDEX) == 'w') {
                        builder.append(word).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + fileName, e);
        }
        String[] filteredWords = builder.toString().split(" ");
        Arrays.sort(filteredWords);
        return builder.isEmpty() ? new String[0] : filteredWords;
    }
}
