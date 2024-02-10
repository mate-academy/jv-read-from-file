package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String[] EMPTY_ARRAY = new String[0];

    public String[] readFromFile(String fileName) {
        StringBuilder stringOfWords = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                stringOfWords.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringOfWords.length() == 0) {
            return EMPTY_ARRAY;
        }
        String[] wordsArray = stringOfWords
                .toString()
                .toLowerCase(Locale.ROOT)
                .split("\\W+");
        stringOfWords.setLength(0);
        if (wordsArray.length > 0) {
            for (String word : wordsArray) {
                if (word.charAt(0) == 'w') {
                    stringOfWords.append(word).append(' ');
                }
            }
        }
        if (stringOfWords.length() == 0) {
            return EMPTY_ARRAY;
        }
        wordsArray = stringOfWords.toString().split(" ");
        Arrays.sort(wordsArray);
        return wordsArray;
    }
}
