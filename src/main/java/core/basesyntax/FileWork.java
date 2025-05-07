package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        if (fileName == null) {
            return null;
        } else {
            File file = new File(fileName);
            String[] words;
            try {
                List<String> strings = Files.readAllLines(file.toPath());
                words = strings.toString().toLowerCase().split("\\W+");
            } catch (IOException e) {
                throw new RuntimeException("cant read file", e);
            }
            int count = 0;
            for (String word : words) {
                if (word.startsWith("w")) {
                    count++;
                }
            }
            String[] filteredWords = new String[count];
            int index = 0;
            for (String word : words) {
                if (word.startsWith("w")) {
                    filteredWords[index++] = word;
                }
            }
            Arrays.sort(filteredWords);
            return filteredWords;
        }
    }
}
