package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        try {
            return Arrays
                    .stream(
                            Files.readAllLines(file.toPath())
                                    .toString()
                                    .split("\\W+")
                    )
                    .map(String::toLowerCase)
                    .filter(lowerCase -> lowerCase.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);

        } catch (IOException e) {
            return new String[]{};
        }
    }
}
