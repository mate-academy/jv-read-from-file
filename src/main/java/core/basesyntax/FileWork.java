package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileWork {
    public String[] readFromFile(String fileName) {
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the file: " + fileName, e);
        }

        String[] words = content.split("\\W+");

        List<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                filteredWords.add(word.toLowerCase());
            }
        }

        filteredWords.sort(String::compareTo);

        return filteredWords.toArray(new String[0]);
    }
}
