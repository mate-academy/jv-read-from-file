package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    private static final String STARTING_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String fileContent = readFile(fileName);

        return Arrays.stream(fileContent.split("[^\\w]"))
                .map(String::toLowerCase)
                .filter(word -> word.startsWith(STARTING_LETTER))
                .sorted()
                .toArray(String[]::new);
    }

    private String readFile(String fileName) {
        String fileContent;
        try {
            fileContent = Files.readString(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file" + fileName, e);
        }
        return fileContent;
    }
}
