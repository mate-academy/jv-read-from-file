package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIAL_LOWERCASE_W_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader
                     = new BufferedReader(new FileReader(new File(fileName)))) {
            StringBuilder allText = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                allText.append(line).append(" ");
                line = bufferedReader.readLine();
            }
            return getWordsWithLowercaseW(allText);
        } catch (IOException e) {
            throw new RuntimeException("ERROR: It seems there is no file: " + fileName, e);
        }
    }

    private String[] getWordsWithLowercaseW(StringBuilder allText) {
        String[] wordsArray = allText.toString().toLowerCase().split("[^\\w]");
        allText = new StringBuilder();
        for (String word : wordsArray) {
            if (word.length() > 0 && word.charAt(0) == SPECIAL_LOWERCASE_W_CHARACTER) {
                allText.append(word).append(" ");
            }
        }
        if (allText.length() == 0) {
            return new String[0];
        }
        wordsArray = allText.substring(0, allText.length() - 1).split(" ");
        Arrays.sort(wordsArray);
        return wordsArray;
    }
}
