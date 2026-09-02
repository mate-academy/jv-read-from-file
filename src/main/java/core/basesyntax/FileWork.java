package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder content = new StringBuilder();

        try {
            for (String line : Files.readAllLines(file.toPath())) {
                content.append(line).append(" ");
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] words = content.toString().split("[\\s\\p{Punct}]+");
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                String lower = word.toLowerCase();
                if (lower.startsWith("w")) {
                    result[index++] = lower;
                }
            }
        }

        Arrays.sort(result);
        return result;
    }
}
