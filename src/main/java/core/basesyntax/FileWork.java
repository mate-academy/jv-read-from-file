package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPECIFIED_REGEX = "[^a-zA-Z]+";

    public String[] readFromFile(String fileName) {

        try {
            String fileInput = Files.readString(Paths.get(fileName));
            String[] arrOfWords = fileInput.split(SPECIFIED_REGEX);

            return Arrays.stream(arrOfWords)
                    .filter(word -> !word.isEmpty())
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith(SPECIFIED_CHARACTER))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            return new String[0];
        }
    }
}
