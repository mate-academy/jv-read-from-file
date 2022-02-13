package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX_SYMBOL = "\\W+";
    private static final String REGEX_WHITESPACES = "\\s+";
    private static final String LOWER_CASE_W = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder filteredWords = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase().split(REGEX_SYMBOL);
                for (String word : words) {
                    if (word.startsWith(LOWER_CASE_W)) {
                        filteredWords.append(word).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!" + fileName, e);
        }
        String words = filteredWords.toString();
        if (words.isEmpty()) {
            return new String[0];
        }
        String[] resultArray = filteredWords.toString().split(REGEX_WHITESPACES);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
