package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String REGEX = "\\W+";
    public static final String MESSAGE = "Cannot read the file";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(MESSAGE, e);
        }
        return getFilteredData(stringBuilder);
    }

    private String[] getFilteredData(StringBuilder stringBuilder) {
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] words = stringBuilder.toString().toLowerCase().split(REGEX);
        String[] filteredWords = new String[words.length];
        int index = 0;
        for (String word : words) {
            if (word != null && word.charAt(0) == 'w') {
                filteredWords[index] = word;
                index++;
            }
        }
        filteredWords = Arrays.copyOfRange(filteredWords, 0, index);
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
