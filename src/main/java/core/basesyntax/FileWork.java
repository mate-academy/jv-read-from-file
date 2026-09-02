package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String content;
        try {
            content = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        content = content.toLowerCase();
        String[] words = content.split("[^a-z]+");
        String[] result = new String[words.length];
        int index = 0;

        for (String textNew : words) {
            if (textNew.startsWith("w")) {
                result[index] = textNew;
                index++;
            }
        }

        String[] finalResult = Arrays.copyOf(result, index);
        Arrays.sort(finalResult);
        return finalResult;
    }
}
