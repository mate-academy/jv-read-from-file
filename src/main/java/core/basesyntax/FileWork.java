package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = Files.readString(Paths.get(fileName));

            String[] words = content.split("[\\p{Punct}\\s]+");

            String[] wordsWithW = new String[words.length];
            int count = 0;
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    wordsWithW[count] = word.toLowerCase();
                    count++;
                }
            }

            if (count == 0) {
                return new String[0];
            }

            String[] result = new String[count];
            System.arraycopy(wordsWithW, 0, result, 0, count);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }
}
