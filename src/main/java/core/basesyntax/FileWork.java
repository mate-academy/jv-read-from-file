package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                for (String word: words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        result.append(word.replaceAll("\\W", "")).append(", ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String joinedWords = result.toString();
        String[] words = joinedWords.split(", ");
        Arrays.sort(words);
        return !joinedWords.isEmpty() ? words : new String[0];
    }
}
