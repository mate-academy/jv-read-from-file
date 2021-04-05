package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String SPLIT_SYMBOLS = "\\s*(\\s|,|\\?|!|\\.)\\s*";
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder filteredWords = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase(Locale.ROOT).split(SPLIT_SYMBOLS);
                for (String word : words) {
                    if (word.startsWith(FIRST_LETTER)) {
                        filteredWords.append(word).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t find or read file", e);
        }
        return createList(filteredWords);
    }

    public String[] createList(StringBuilder builder) {
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] result = builder.toString().split(" ");
        Arrays.sort(result);
        return result;

    }
}
