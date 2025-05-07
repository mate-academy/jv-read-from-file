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
            
            String content = Files.readString(Paths.get(fileName));
            
            String[] words = content.split("\\W+");
            
            List<String> filteredWords = Arrays.stream(words)
                    .filter(word -> word.toLowerCase().startsWith("w"))
                    .map(String::toLowerCase)
                    .sorted()
                    .collect(Collectors.toList());
            
            return filteredWords.toArray(new String[0]);
        } catch (IOException e) {
            
            throw new RuntimeException("Failed to read from file: " + fileName, e);
        }
    }
}
