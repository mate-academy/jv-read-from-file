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
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            String[] words = content.toLowerCase().split("[^a-z]+");
            List<String> filtered = new ArrayList<>();
            for (String word : words) {
                if (word.startsWith("w")) {
                    filtered.add(word);
                }
            }
            Collections.sort(filtered);
            return filtered.toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
            return new String[0];
        }
    }
}


