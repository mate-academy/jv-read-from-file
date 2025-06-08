package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(path);
            String joinedLines = String.join("\n", lines);
            String cleanedLine = joinedLines.replaceAll("[^a-zA-Z ]", " ");
            String lowerCasedLine = cleanedLine.toLowerCase();
            String[] words = lowerCasedLine.split("\\s+");
            List<String> result = new ArrayList<>();
            for (String word : words) {
                if (word.isEmpty()) {
                    continue;
                }
                char firstChar = word.charAt(0);
                if (firstChar == 'w') {
                    result.add(word);
                }
            }
            Collections.sort(result);
            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + fileName, e);
        }
    }
}
