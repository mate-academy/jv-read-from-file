package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX = "\\W+";
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line)
                        .append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException("Can`t read a file " + fileName, ex);
        }

        return Arrays.stream(stringBuilder.toString()
                        .split(REGEX))
                .map(String::toLowerCase)
                .filter(str -> str.startsWith(SPECIFIED_CHARACTER))
                .sorted(String::compareTo)
                .toArray(String[]::new);
    }
}
