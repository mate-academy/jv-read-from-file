package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private static final String SEPARATION_REGEX = "\\W+";
    private static final String REQUESTED_START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String[] words;
        try {
            String text = Files.readString(Path.of(fileName)).toLowerCase();
            if (text.isEmpty()) {
                return new String[0];
            }
            words = text.split(SEPARATION_REGEX);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read from file", e);
        }

        Arrays.sort(words);

        StringBuilder resultString = new StringBuilder();
        for (String word : words) {
            if (word.startsWith(REQUESTED_START_LETTER)) {
                resultString.append(word)
                        .append(" ");
            }
        }
        return resultString.toString().isEmpty()
                ? new String[0]
                : resultString.toString().strip().split(" ");
    }
}
