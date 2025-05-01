package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String PUNCTUATION_REGEX = "\\W+";
    private static final String STARTING_WITH = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .flatMap(l -> Arrays.stream(l.split(PUNCTUATION_REGEX)))
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith(STARTING_WITH))
                    .sorted()
                    .toArray(String[]::new);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("IO exception is occurred", e);
        }
    }
}
