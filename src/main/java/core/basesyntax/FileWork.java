package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String content = "";
        try {
            content = Files.readString(Path.of(fileName));
            if (content == null) {
                return new String[0];
            }

            String[] words = content.toLowerCase().split("\\W+");

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

            Arrays.sort(filteredWords, Comparator.naturalOrder());

            return filteredWords;

        } catch (IOException e) {
            System.out.println("file exception" + e);
        }
        return new String[0];
    }
}
