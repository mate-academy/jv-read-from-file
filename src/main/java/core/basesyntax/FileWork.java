package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileWork {
    private static final char SPECIAL_LOWERCASE_W_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder allText = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                allText.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("ERROR: It seems there is no file: " + fileName, e);
        }
        return getWordsWithLowerCaseW(allText);
    }

    private String[] getWordsWithLowerCaseW(StringBuilder allText) {
        if (allText.toString().isEmpty()) {
            return new String[0];
        }
        List<String> listOfWords = new LinkedList<>(
                Arrays.asList(allText.toString().split("[^\\w]")));
        listOfWords.replaceAll(String::toLowerCase);
        listOfWords.removeIf(word -> word.isEmpty()
                || word.charAt(0) != SPECIAL_LOWERCASE_W_CHARACTER);
        Collections.sort(listOfWords);
        return listOfWords.toArray(new String[0]);
    }
}
