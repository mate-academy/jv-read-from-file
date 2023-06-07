package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPLIT_PATTERN = "\\W+";
    private static final String MATCH_STRING = "w";

    public String[] readFromFile(String fileName) {
        List<String> linesFromFile;
        try {
            linesFromFile = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linesFromFile.stream()
                            .map(s -> s.split(SPLIT_PATTERN))
                            .flatMap(Arrays::stream)
                            .map(String::toLowerCase)
                            .filter(s -> s.startsWith(MATCH_STRING))
                            .sorted()
                            .toArray(String[]::new);
    }
}
