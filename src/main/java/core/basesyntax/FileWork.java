package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Unable to read provided file", e);
        }
        List<String> filteredWords = new ArrayList<>();
        for (String line : lines) {
            filteredWords.addAll(Arrays.stream(line.split("\\W+"))
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith("w"))
                    .toList());
        }
        filteredWords.sort(String::compareTo);

        return filteredWords.toArray(new String[0]);
    }
}
