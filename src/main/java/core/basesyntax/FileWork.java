package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] resultWords = new String[0];
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String lineFromFile = bufferedReader.readLine();
            while (lineFromFile != null) {
                stringBuilder.append(lineFromFile).append(" ");
                lineFromFile = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        if (stringBuilder.length() == 0) {
            return resultWords;
        }

        String[] wordsFromFile = stringBuilder.toString().split("\\W+");
        String filteredWords = filterByFirstLetter(wordsFromFile, 'w');
        if (filteredWords.length() == 0) {
            return resultWords;
        }

        resultWords = filteredWords.split(" ");
        Arrays.sort(resultWords);
        return resultWords;
    }

    private String filterByFirstLetter(String[] words, char firstLetter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.charAt(0) == SPECIFIED_CHARACTER
                    || word.charAt(0) == Character.toUpperCase(SPECIFIED_CHARACTER)) {
                stringBuilder.append(word.toLowerCase()).append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
