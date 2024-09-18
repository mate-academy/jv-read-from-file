package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = Files.readString(Path.of(fileName));

            String[] words = content.split("\\W+");

            //convert to lowerCase
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
            }

            int countOfWords = 0;
            for (String word : words) {
                if (word.startsWith("w")) {
                    countOfWords++;
                }
            }

            String[] filteredWords = new String[countOfWords];

            int indexArray = 0;
            for (String word : words) {
                if (word.startsWith("w")) {
                    filteredWords[indexArray++] = word;
                }
            }

            Arrays.sort(filteredWords);

            return filteredWords;

        } catch (IOException e) {
            throw new RuntimeException("Can't read information from file");
        }
    }
}
