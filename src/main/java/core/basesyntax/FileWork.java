package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            return Files.readAllLines(new File(fileName).toPath()).stream()
                    .map(s -> s.replaceAll("[^a-zA-Z ]", ""))
                    .map(s -> s.split(" "))
                    .flatMap(Arrays::stream)
                    .map(String::toLowerCase)
                    .filter(s -> s.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Specified exception text: " + System.lineSeparator(), e);
        }
    }
}
