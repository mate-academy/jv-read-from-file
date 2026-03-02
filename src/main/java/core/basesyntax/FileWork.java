package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        Path path = Path.of(fileName);
        String[] content;

        try {
            content = Files.readString(path).split("[\\s\\p{Punct}]+");
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        int count = 0;

        for (String word : content) {
            if (word.toLowerCase().startsWith("w")) {
                count++;
            }
        }

        String[] filteredWords = new String[count];

        int index = 0;
        for (String s : content) {
            String word = s.toLowerCase();
            if (word.startsWith("w")) {
                filteredWords[index++] = word;
            }
        }

        Arrays.sort(filteredWords);

        return filteredWords;
    }
}
