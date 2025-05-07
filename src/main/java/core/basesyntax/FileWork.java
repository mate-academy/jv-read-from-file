package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String NOT_EXISTING_FILE = "There is not such fileName -> %s";
    private static final String SPLIT_REGEX = "[^a-z]";
    private static final String FILTER_START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        Path pathOfFile = Path.of(fileName);
        String[] resultStringArray;
        try {
            List<String> stringList = Arrays.asList(
                    Files.readAllLines(pathOfFile)
                            .toString()
                            .toLowerCase()
                            .split(SPLIT_REGEX));
            resultStringArray = stringList.stream()
                    .filter(s -> s.startsWith(FILTER_START_LETTER))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException(String.format(NOT_EXISTING_FILE, fileName), e);
        }
        return resultStringArray;
    }
}
