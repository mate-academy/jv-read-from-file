package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            List<String> words = Files.lines(Path.of(fileName))
                    .flatMap(line -> Arrays.stream(line.toLowerCase().split("[^a-zA-Z]+")))
                    .filter(word -> word.startsWith(SPECIFIED_CHARACTER))
                    .sorted()
                    .collect(Collectors.toList());

            return words.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
    }
}
