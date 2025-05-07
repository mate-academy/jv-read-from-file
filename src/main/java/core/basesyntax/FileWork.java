package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));

            String[] words = content.toLowerCase().split("[\\W]+");

            List<String> filteredWords = Arrays.stream(words)
                    .filter(word -> word.startsWith("w"))
                    .sorted()
                    .collect(Collectors.toList());

            return filteredWords.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't filter the file");
        }
    }
}
