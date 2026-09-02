package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final String REGEX_WORD_PATTERN = "\\W+";
    private static final String SEPARATOR = " ";
    private static final String EMPTY_STRING = "";
    private static final int WORD_START = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase().split(REGEX_WORD_PATTERN);
                for (String currentWord : words) {
                    if (currentWord.charAt(WORD_START) == SPECIFIED_CHARACTER) {
                        stringBuilder.append(currentWord).append(SEPARATOR);
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
        String resultString = stringBuilder.toString();
        if (resultString.equals(EMPTY_STRING)) {
            return new String[0];
        } else {
            String[] resultArray = resultString.split(SEPARATOR);
            Arrays.sort(resultArray);
            return resultArray;
        }
    }
}
