package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String fileContent;

        try {
            fileContent = Files.readString(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return !fileContent.isEmpty() ? Arrays.stream(fileContent.split("\\W+"))
                .filter(string -> string.matches("[wW]\\w*"))
                .map(String::toLowerCase)
                .sorted()
                .toArray(String[]::new) : new String[] {};
    }
}
