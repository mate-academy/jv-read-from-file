package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPLIT_REGEX = "\\W+";
    private static final String SPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (String word : line.split(SPLIT_REGEX)) {
                    String wordToLowerCase = word.toLowerCase();
                    if (wordToLowerCase.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(wordToLowerCase).append(SPACE);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        if (stringBuilder.length() > 0) {
            String[] resultWords = stringBuilder.toString().split(SPACE);
            Arrays.sort(resultWords);
            return resultWords;
        }
        return new String[0];
    }
}
