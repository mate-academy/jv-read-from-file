package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> list;
        String[] wordsArray;
        File file = new File(fileName);
        StringBuilder words = new StringBuilder();
        try {
            list = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        for (String word : list.toString().toLowerCase().trim().split("\\W+")) {
            if (word.toLowerCase().startsWith("w")) {
                words.append(word).append(",");
            }
        }
        wordsArray = words.toString().toLowerCase().split(",");
        Arrays.sort(wordsArray);
        return words.length() > 0 ? wordsArray : new String[0];
    }
}
