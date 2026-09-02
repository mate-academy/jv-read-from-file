package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SYMBOL_TO_SPLIT = "\\W+";
    private static final char CHAR_TO_FILTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (builder.isEmpty()) {
            return new String[0];
        }
        String[] splittedText = builder.toString().toLowerCase().split(SYMBOL_TO_SPLIT);
        int counter = 0;
        for (String word : splittedText) {
            if (word.charAt(0) == CHAR_TO_FILTER) {
                counter++;
            }
        }
        String[] filteredText = new String[counter];
        for (int i = 0; i < filteredText.length; i++) {
            for (String word : splittedText) {
                if (word.charAt(0) == CHAR_TO_FILTER) {
                    filteredText[i] = word;
                    i++;
                }
            }
        }
        Arrays.sort(filteredText);
        return filteredText;
    }
}
