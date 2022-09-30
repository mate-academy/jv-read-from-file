package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char FILTER_VALUE = 'w';
    private static final String REGEX_FOR_WORDS = "[$&+,:;=?@#|'<>.-^*()%!\\r\\n ]+";
    private int countOfFilteredWords = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultStringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read text from file", e);
        }
        if (resultStringBuilder.length() == 0) {
            return new String[] {};
        }
        String[] wordsFromFile = resultStringBuilder.toString()
                .toLowerCase().split(REGEX_FOR_WORDS);
        for (int i = 0; i < wordsFromFile.length; i++) {
            if (wordsFromFile[i].charAt(0) == FILTER_VALUE) {
                countOfFilteredWords += 1;
            }
        }
        String[] filteredWords = new String[countOfFilteredWords];
        for (int i = 0, j = 0; i < wordsFromFile.length; i++) {
            if (wordsFromFile[i].charAt(0) == FILTER_VALUE) {
                filteredWords[j] = wordsFromFile[i];
                j++;
            }
        }
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
