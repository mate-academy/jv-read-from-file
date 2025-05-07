package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName))).toLowerCase();

            String[] words = content.replaceAll("[^a-z\\s]", "").split("\\s+");

            int count = 0;
            for (String word : words) {
                if (word.startsWith("w")) {
                    count++;
                }
            }

            if (count == 0) {
                return new String[0];
            }

            String[] result = new String[count];
            int index = 0;

            for (String word : words) {
                if (word.startsWith("w")) {
                    result[index++] = word;
                }
            }

            Arrays.sort(result);

            return result;

        } catch (IOException e) {
            throw new RuntimeException("The file cannot be read.", e);
        }
    }
}
