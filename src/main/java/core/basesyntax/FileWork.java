package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.nio.file.Paths;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here

        String content = null;
        try {
            content = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] wynik = Arrays.stream(content.split("\\s+"))
                .map(s -> s.replaceAll("\\p{Punct}", ""))
                .map(String::toLowerCase)
                .filter(s -> s.startsWith("w"))
                .filter(s -> !s.isBlank())
                .sorted()
                .toArray(String[]::new);

        return wynik;
    }
}
