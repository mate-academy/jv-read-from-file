package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";
    public static final String SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String value = bufferedReader.readLine();
                    value != null; value = bufferedReader.readLine()) {
                for (String word : value.split(SEPARATOR)) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(word.toLowerCase()
                                .replaceAll("[.,!?]", ""))
                                .append(System.lineSeparator());
                    }
                }
            }
            if (stringBuilder.length() > 1) {
                String[] result = stringBuilder.toString().split(System.lineSeparator());
                Arrays.sort(result);
                return result;
            }
            return new String[0];
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
