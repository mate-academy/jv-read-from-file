package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPLITTER = "\\W+";
    private static final char LETTER_TO_CHECK = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return bufferedReader.lines()
                    .flatMap(line -> Arrays.stream(line.split(SPLITTER)))
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith(String.valueOf(LETTER_TO_CHECK)))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
