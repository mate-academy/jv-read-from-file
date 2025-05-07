package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String bigString;
        try {
            bigString = Files.readString(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file.", e);
        }
        return Arrays.stream(bigString.split("\\W+"))
                .map(String::toLowerCase)
                .filter(s -> s.startsWith("w"))
                .sorted().toArray(String[]::new);
    }
}
