package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPACE = " ";
    private StringBuilder stringBuilder;

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return processText(String.valueOf(stringBuilder));
    }

    private String[] processText(String text) {
        String[] words = stringBuilder.toString().split("\\W+");
        stringBuilder = new StringBuilder();
        for (String word : words) {
            word = word.toLowerCase();
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                stringBuilder.append(word).append(SPACE);
            }
        }
        if (stringBuilder.isEmpty()) {
            return new String[0];
        }
        words = stringBuilder.toString().split(SPACE);
        Arrays.sort(words);
        return words;
    }
}
