package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPECIFIED_REGEX = "\\W+";
    private static final String SPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split(SPECIFIED_REGEX)) {
                    String lowerCaseWord = word.toLowerCase();
                    if (lowerCaseWord.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(lowerCaseWord).append(SPACE);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file" + fileName, e);
        }
        if (stringBuilder.length() > 0) {
            String[] resultWords = stringBuilder.toString().split(SPACE);
            Arrays.sort(resultWords);
            return resultWords;
        }
        return new String[0];
    }
}
