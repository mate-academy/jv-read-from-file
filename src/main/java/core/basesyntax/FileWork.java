package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String START_LETTER = "w";
    private static final String WHITESPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(WHITESPACE);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file", e);
        }
        String[] text = builder.toString().split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : text) {
            if (word.toLowerCase().startsWith(START_LETTER)) {
                stringBuilder.append(word.toLowerCase()).append(WHITESPACE);
            }
        }
        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().split("\\W+");
        Arrays.sort(result);
        return result;
    }
}
