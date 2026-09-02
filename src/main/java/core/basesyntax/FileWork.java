package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char FIRST_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        String line;
        StringBuilder builder = new StringBuilder();
        String[] result;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(getWordsStartsFrom(FIRST_LETTER, line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file" + e);
        }
        result = builder.toString().split(" ");
        Arrays.sort(result);
        return builder.length() == 0 ? new String[0] : result;
    }

    private StringBuilder getWordsStartsFrom(char firstLetter, String line) {
        StringBuilder result = new StringBuilder();
        String[] splittedLine = line.toLowerCase().split(" ");
        for (String word : splittedLine) {
            if (word.charAt(0) == firstLetter) {
                result.append(word.replaceAll("[^a-z]", ""))
                        .append(" ");
            }
        }
        return result;
    }
}
