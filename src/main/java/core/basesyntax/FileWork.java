package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String FILTER_MARKER_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }

        return Arrays.stream(stringBuilder.toString().split("\\W+"))
                .map(String::toLowerCase).filter(s -> s.startsWith(FILTER_MARKER_CHARACTER))
                .sorted().toArray(String[]::new);
    }
}
