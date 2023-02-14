package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            String[] allWords = strings.toString().toLowerCase().split("\\W");

            for (String word : allWords) {
                if (word.startsWith("w")) {
                    stringBuilder.append(word).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] finalString = stringBuilder.toString().split(" ");
        Arrays.sort(finalString);
        return finalString;
    }
}
