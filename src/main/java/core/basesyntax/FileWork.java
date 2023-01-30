package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String PUNCTUATION_MARK = "\\p{Punct}+";
    private static final String SPACE_MARK = " ";
    private String[] wordsOfFile;

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        int value;
        String line = null;
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File(fileName)))) {
            value = bufferedReader.read();
            if (value != -1) {
                return new String[]{};
            }
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException exception) {
            throw new RuntimeException("Can't read file", exception);
        }
        line = stringBuilder.toString();
        line = line.replaceAll(PUNCTUATION_MARK, SPACE_MARK).toLowerCase();
        wordsOfFile = line.split(SPACE_MARK);
        Arrays.sort(wordsOfFile);
        stringBuilder.setLength(0);
        for (String word : wordsOfFile) {
            if (startWithLetter(word)) {
                stringBuilder.append(word).append(SPACE_MARK);
            }
        }
        return stringBuilder.toString().split(SPACE_MARK);
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
