package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WORD_SEPARATOR = (" ");
    private static final String FILTER_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file",e);
        }
        String[] words = builder.toString().toLowerCase().split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.startsWith(FILTER_LETTER)) {
                stringBuilder.append(word).append(WORD_SEPARATOR);
            }
        }
        String[] filteredWords = stringBuilder.toString().split(WORD_SEPARATOR);
        if (filteredWords[0].equals("")) {
            return new String[] {};
        }
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
