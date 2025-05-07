package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String NON_WORD_CHARACTERS_REGEX = "\\W+";
    private static final String FILTER_LETTER = "w";
    private static final String WORD_SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] allWords = stringBuilder.toString().toLowerCase().split(NON_WORD_CHARACTERS_REGEX);
        if (allWords[0].equals("")) {
            return new String[] {};
        }
        stringBuilder.setLength(0);
        for (String word : allWords) {
            if (word.startsWith(FILTER_LETTER)) {
                stringBuilder.append(word).append(WORD_SEPARATOR);
            }
        }
        String[] filteredWords = stringBuilder.toString().split(WORD_SEPARATOR);
        if (filteredWords[0].equals("")) {
            return new String[] {};
        }
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
