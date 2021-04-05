package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SEPARATOR = "\\W+";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            for (String line = bufferedReader.readLine();
                    line != null; line = bufferedReader.readLine()) {
                for (String word : line.toLowerCase().split(SEPARATOR)) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(word.replace(SEPARATOR, ""))
                                .append(System.lineSeparator());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        if (stringBuilder.length() > 1) {
            String[] result = stringBuilder.toString().split(System.lineSeparator());
            Arrays.sort(result);
            return result;
        }
        return new String[0];
    }
}
