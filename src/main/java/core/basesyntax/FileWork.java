package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));

            return lines.stream()
                    .flatMap(line -> Arrays.stream(line.toLowerCase().split("\\W+")))
                    .filter(word -> word.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[0];
    }

}
