package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> list;

        try {
            list = Files.readAllLines(Path.of(fileName));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.stream()
                .flatMap(line -> List.of(line.split("[\\s\\p{Punct}]+")).stream())
                .map(String::toLowerCase)
                .filter(word -> word.startsWith("w"))
                .sorted()
                .toArray(String[]::new);
    }
}
