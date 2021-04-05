package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                getAllWordsWithW(value, builder);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("can't read from file", e);
        }
        return toStringArray(builder);
    }

    private void getAllWordsWithW(String input, StringBuilder builder) {
        input = input.replaceAll("[^a-z A-Z]", "")
                .toLowerCase();
        String[] wordsFromLine = input.split(" ");
        for (String word : wordsFromLine) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                builder.append(word).append(' ');
            }
        }
    }

    private String[] toStringArray(StringBuilder builder) {
        if (builder.length() != 0) {
            String[] result = builder.toString().trim().split(" ");
            Arrays.sort(result);
            return result;
        }
        return new String[0];
    }
}
