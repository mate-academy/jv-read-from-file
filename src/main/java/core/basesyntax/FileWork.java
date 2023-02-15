package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String EXCEPTION_WORDS_PATTERN = "[^a-z ]";
    private static final String WORDS_SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        String[] result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String lines = bufferedReader.readLine();
            while (lines != null) {
                String[] wordsFromLine = lines.toLowerCase()
                        .replaceAll(EXCEPTION_WORDS_PATTERN, WORDS_SEPARATOR)
                        .split(WORDS_SEPARATOR);
                lines = bufferedReader.readLine();
                for (String word : wordsFromLine) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        builder.append(word).append(WORDS_SEPARATOR);
                    }
                }
            }
            result = builder.toString().split(WORDS_SEPARATOR);
            Arrays.sort(result);
            if (builder.toString().length() == 0) {
                 return new String[] {};
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file",e);
        }
    }
}
