package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX = "\\W+";
    private static final String WORD_SEPARATOR = " ";
    private static final String START_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().toLowerCase().split(REGEX);
            for (String word : words) {
                if (word.startsWith(START_CHARACTER)) {
                    result.append(word).append(WORD_SEPARATOR);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        if (result.length() <= 0) {
            return new String[0];
        }
        String[] resultArray = result.toString().split(WORD_SEPARATOR);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
