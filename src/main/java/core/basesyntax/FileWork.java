package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from a file", e);
        }
        List<String> result = new ArrayList<>();
        for (String line : data) {
            String[] arrayOfWords = line.toLowerCase().split("\\W+");
            for (String word : arrayOfWords) {
                if (word.startsWith("w")) {
                    result.add(word);
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
