package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWork {
    private static final String FILE_NOT_FOUND_EXCEPTION = "Couldn't find file with name =>";
    private static final String REGEX = "\\W+";

    public String[] readFromFile(String filename) {
        String fileContent;
        try {
            fileContent = Files.readAllLines(Path.of(filename))
                    .stream()
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException(FILE_NOT_FOUND_EXCEPTION + filename, e);
        }
        String[] split = fileContent.split(REGEX);
        return Arrays.stream(split)
                .map(String::toLowerCase)
                .filter(string -> string.startsWith("w"))
                .sorted()
                .toArray(String[]::new);
    }
}
