package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char STARTING_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return getFilteredData(stringBuilder);
    }

    public String[] getFilteredData(StringBuilder stringBuilder) {
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] allWords = stringBuilder.toString().toLowerCase().split("\\W+");
        String[] words = new String[allWords.length];
        int index = 0;
        for (String word : allWords) {
            if (word != null && word.charAt(0) == STARTING_CHAR) {
                words[index] = word;
                index++;
            }
        }
        words = Arrays.copyOfRange(words, 0, index);
        Arrays.sort(words);
        return words;
    }
}
