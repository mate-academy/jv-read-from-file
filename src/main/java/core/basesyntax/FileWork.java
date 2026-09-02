package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String text = Files.readString(Paths.get(fileName));
            String[] tokens = text.split("[^A-Za-z0-9]+");
            List<String> words = new ArrayList<>();
            for (String t : tokens) {
                if (t == null || t.isBlank()) {
                    continue;
                }
                String lower = t.toLowerCase();
                if (lower.startsWith("w")) {
                    words.add(lower);
                }
            }
            Collections.sort(words);
            return words.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
