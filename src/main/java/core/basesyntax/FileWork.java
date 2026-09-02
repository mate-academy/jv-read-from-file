package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));

            String[] words = fileContent.split("[^a-zA-Z]+");

            List<String> filteredWords = new ArrayList<>();
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    filteredWords.add(word.toLowerCase());
                }
            }

            filteredWords.sort(String.CASE_INSENSITIVE_ORDER);

            return filteredWords.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
