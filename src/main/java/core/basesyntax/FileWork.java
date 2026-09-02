package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String FIRST_LETTER = "w";
    public static final String WORD_SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader((new FileReader(fileName)));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                String[] splittString = value.split("\\W+");
                for (String word : splittString) {
                    if (word.toLowerCase().startsWith(FIRST_LETTER)) {
                        stringBuilder.append(word.toLowerCase()).append(WORD_SEPARATOR);
                    }
                }
                value = reader.readLine();
            }
            String[] filteredWords = stringBuilder.toString().split(WORD_SEPARATOR);
            Arrays.sort(filteredWords);
            return filteredWords.length > 1 ? filteredWords : new String[] {};
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
