package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {

        File file = new File(fileName);

        try {
            String strings = new String(Files.readAllBytes(file.toPath()));
            List<String> words = Arrays.asList(strings.split("\\W+"));
            return words.stream()
                    .map(String::toLowerCase)
                    .filter(lowerCase -> lowerCase.startsWith(SPECIFIED_CHARACTER))
                    .sorted()
                    .toArray(String[]::new);

        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + e);
        }
    }
}
