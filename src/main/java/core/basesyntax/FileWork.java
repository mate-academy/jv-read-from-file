package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String fileText = "";
        try {
            fileText = Files.readString(Paths.get(fileName));

        } catch (IOException e) {
            throw new RuntimeException("Some problems with file");
        }

        if (fileText.length() == 0) {
            return new String[0];
        }

        return Arrays.stream(fileText.split("\\W+"))
                .map(String::toLowerCase)
                .filter(s -> s.startsWith(FIRST_LETTER))
                .sorted()
                .toArray(String[]::new);
    }
}
