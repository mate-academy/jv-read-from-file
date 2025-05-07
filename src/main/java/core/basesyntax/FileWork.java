package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        String words;
        try {
            words = Files.readAllLines(file.toPath())
                    .toString()
                    .toLowerCase()
                    .replaceAll("[^a-zA-Z]+", " ");
        } catch (IOException e) {
            throw new RuntimeException("Cant read this file", e);
        }
        for (String currentWord : words.split(" ")) {
            if (currentWord.startsWith("w")) {
                stringBuilder.append(currentWord).append(" ");
            }
        }
        if (stringBuilder.isEmpty()) {
            return new String[]{};
        }
        String[] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
