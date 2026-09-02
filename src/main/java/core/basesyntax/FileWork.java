package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char SEEKING_CHAR = 'w';
    private static final String FILTER_REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            List<String> allLines = Files.readAllLines(file.toPath());
            int count = 0;
            for (String line : allLines) {
                String[] words = line.split(FILTER_REGEX);
                for (String word : words) {
                    if (word.toLowerCase().charAt(0) == SEEKING_CHAR) {
                        count++;
                    }
                }
            }
            String[] result = new String[count];
            int i = 0;
            for (String line : allLines) {
                String[] words = line.split(FILTER_REGEX);
                for (String word : words) {
                    if (word.toLowerCase().charAt(0) == SEEKING_CHAR) {
                        result[i++] = word.toLowerCase();
                    }
                }
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
