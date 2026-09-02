package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = Files.readString(new File(fileName).toPath());
            String[] words = content.split("[^a-zA-Z]+");

            int counter = 0;
            for (String word : words) {
                if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                    counter++;
                }
            }
            if (counter == 0) {
                return new String[0];
            }

            String[] result = new String[counter];
            int index = 0;
            for (String word : words) {
                if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                    result[index++] = word.toLowerCase();
                }
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName, e);
        }

    }
}
