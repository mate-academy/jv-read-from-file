package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String allWords = Files.readString(Path.of(fileName));
            String[] words = allWords.toLowerCase().split(("[\\s\\p{Punct}]+"));
            int count = 0;

            for (String word : words) {
                if (word.startsWith("w")) {
                    count++;
                }
            }
            String[] result = new String[count];
            int index = 0;

            for (String word : words) {
                if (word.startsWith("w")) {
                    result[index] = word;
                    index++;
                }
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
