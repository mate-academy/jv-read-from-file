package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            return getWordsStartingWithW(fileName);
        } catch (IOException e) {
            throw new RuntimeException("There was a problem during reading file from path: "
                    + fileName, e);
        }

    }

    private static String[] getWordsStartingWithW(String fileName) throws IOException {
        return Files.readAllLines(Path.of(fileName)).stream().map(line -> line.split("\\W+"))
                .flatMap(Stream::of)
                .map(String::toLowerCase)
                .filter(word -> word.startsWith("w"))
                .sorted()
                .toArray(String[]::new);
    }
}
