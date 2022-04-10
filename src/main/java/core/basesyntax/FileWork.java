package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path path = Path.of(fileName);
        if (!Files.exists(path)) {
            return new String[0];
        }
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Reading error", e);
        }
        List<String> result = filterWordsStartingWithW(lines);
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private List<String> filterWordsStartingWithW(List<String> lines) {
        List<String> words = new ArrayList<>();
        for (String sentence : lines) {
            String[] split = sentence.split("\\W+");
            for (String s : split) {
                words.add(s.toLowerCase());
            }
        }
        words.removeIf(s -> !s.matches("^w.*"));
        return words;
    }
}
