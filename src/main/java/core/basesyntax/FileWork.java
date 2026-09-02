package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            List<String> data = Files.readAllLines(new File(fileName).toPath());
            return data.stream()
                    .flatMap(l -> Arrays.stream(l.split("\\W+")))
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith(SPECIFIED_CHARACTER))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
    }
}
