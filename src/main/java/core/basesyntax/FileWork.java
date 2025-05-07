package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Given file doesn't exist", e);
        }
        return Arrays.stream(filterString(text.toString())).sorted().toArray(String[]::new);
    }

    private String[] filterString(String text) {
        if (text == null) {
            return new String[0];
        }
        String[] words = text.split("\\W+");
        int suitableWordsCount = 0;
        for (String word : words) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                suitableWordsCount++;
            }
        }
        String[] result = new String[suitableWordsCount];
        int index = 0;
        for (String word : words) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                result[index++] = word.toLowerCase();
            }
        }
        return result;
    }
}
