package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX = "\\W+";
    private static final String SEARCHED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split(REGEX);
                for (String word : words) {
                    if (word.startsWith(SEARCHED_CHARACTER)) {
                        result.append(word).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (result.isEmpty()) {
            return new String[0];
        }

        String[] filteredWords = result.toString().split(" ");
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
