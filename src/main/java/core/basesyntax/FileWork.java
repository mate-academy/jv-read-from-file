package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = new String(Files.readAllBytes(Path.of(fileName)));
            String []words = content.split("[\\s\\p{Punct}]+");
            String []filteredWords = new String[words.length];
            int count = 0;

            for (String word : words) {
                if (word.startsWith("w") || word.startsWith("W")) {
                    filteredWords[count++] = word.toLowerCase();
                }
            }

            filteredWords = Arrays.copyOf(filteredWords, count);
            Arrays.sort(filteredWords);
            return filteredWords;
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
