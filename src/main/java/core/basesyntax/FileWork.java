package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] list = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {
            list = bufferedReader
                    .lines()
                    .flatMap(a -> Arrays.stream(a.split(" ")))
                    .filter(s -> s.startsWith("w") || s.startsWith("W"))
                    .map(s -> s.replaceAll("[^A-Za-z0-9]+", ""))
                    .map(String::toLowerCase)
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
