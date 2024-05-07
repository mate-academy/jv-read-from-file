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
            List<String> filterWords = new ArrayList<>();
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    filterWords.add(word.toLowerCase());
                }
            }

            filterWords.sort(String.CASE_INSENSITIVE_ORDER);

            return filterWords.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Cant read a file", e);
        }
    }
}
