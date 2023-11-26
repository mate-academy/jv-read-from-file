package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = new String(Files.readAllBytes(Path.of(fileName)));
            String[] word = content.split("\\W+");
            String[] finalWords = new String[word.length];
            int counter = 0;
            for (String words: word) {
                if (words.startsWith("w") || words.startsWith("W")) {
                    finalWords[counter] = words.toLowerCase();
                    counter++;
                }
            }
            finalWords = Arrays.copyOf(finalWords, counter);
            Arrays.sort(finalWords);
            return finalWords;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
