package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            String text = String.join(" ", lines);
            String[] words = text.split("[^A-Za-z0-9]+");

            for (String word : words) {
                if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                    result.add(word.toLowerCase());
                }
            }
            Collections.sort(result);
            return result.toArray(new String[0]);

        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + fileName, e);
        }
    }
}
