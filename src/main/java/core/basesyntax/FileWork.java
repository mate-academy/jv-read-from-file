package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String text = Files.readString(Path.of(fileName));

            String[] words = text.toLowerCase().split("\\W+");

            String[] tempResult = new String[words.length];
            int count = 0;

            for (String word : words) {
                if (!word.isEmpty() && word.startsWith("w")) {
                    tempResult[count] = word;
                    count++;
                }
            }

            String[] result = Arrays.copyOf(tempResult, count);
            Arrays.sort(result);

            return result;

        } catch (IOException e) {

            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }
}

