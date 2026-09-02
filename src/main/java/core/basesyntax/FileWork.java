package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        File file = new File(fileName);
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.startsWith("w") || word.startsWith("W")) {
                        result.add(word.replaceAll("[^a-zA-Z]", "").toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read the file", e);
        }
        return result.stream().sorted().toArray(String[]::new);
    }
}
