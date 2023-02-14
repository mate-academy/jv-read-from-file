package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String FIRST_LETTER_IN_WORD = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
        String regex = String.format("\\b(?![%s%s])\\w+",
                FIRST_LETTER_IN_WORD, FIRST_LETTER_IN_WORD.toUpperCase());
        String[] words = builder.toString()
                .replaceAll(regex, "")
                .replaceAll("[^\\w\\s]", "")
                .replaceAll("\\s+", " ")
                .trim()
                .toLowerCase()
                .split(" ");
        Arrays.sort(words);
        return words[0].length() == 0 ? new String[0] : words;
    }
}
