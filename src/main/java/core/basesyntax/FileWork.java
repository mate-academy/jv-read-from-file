package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WORD_START_W = "w";
    private static final String WHITESPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder lines = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                lines.append(value.toLowerCase()).append(WHITESPACE);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file " + fileName, e);
        }

        String[] wordsFromLines = lines.toString().split(WHITESPACE);
        StringBuilder words = new StringBuilder();

        for (String word : wordsFromLines) {
            if (word.startsWith(WORD_START_W)) {
                words.append(word.replaceAll("[^a-z]","")).append(WHITESPACE);
            }
        }

        String[] wordsWithW = words.length() != 0
                ? words.toString().split(WHITESPACE) : new String[0];
        Arrays.sort(wordsWithW);

        return wordsWithW;
    }
}
