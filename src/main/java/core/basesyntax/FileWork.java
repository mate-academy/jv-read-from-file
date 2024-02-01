package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String... fileNames) {
        List<String> wordsStartingWithW = new ArrayList<>();

        for (String fileName : fileNames) {
            File file = new File(fileName);
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                for (String line : lines) {
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        // Вилучення знаків пунктуації та перетворення у нижній регістр
                        word = word.replaceAll("[^\\w]", "").toLowerCase();
                        if (!word.isEmpty() && word.startsWith("w")) {
                            wordsStartingWithW.add(word);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Error reading from file: " + fileName, e);
            }
        }

        Collections.sort(wordsStartingWithW); // Сортування перед поверненням результату
        return wordsStartingWithW.toArray(new String[0]);
    }
}
