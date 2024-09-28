package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = new String(Files.readAllBytes(new File(fileName).toPath()));

            String[] words = content.toLowerCase().split("[^a-z]+");

            int count = 0;
            for (String word : words) {
                if (word.startsWith("w") && !word.isEmpty()) {
                    count++;
                }
            }

            String[] filteredWords = new String[count];
            int index = 0;

            for (String word : words) {
                if (word.startsWith("w") && !word.isEmpty()) {
                    filteredWords[index++] = word;
                }
            }

            Arrays.sort(filteredWords);

            return filteredWords;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String[]{};
    }
}
