package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

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
            throw new RuntimeException("can't read from file");
        }
        return toStringArray(builder);
    }

    private void getAllWordsWithW(String input, StringBuilder builder) {
        input = input.replaceAll("[^a-z A-Z]", "")
                .toLowerCase(Locale.ROOT);
        String[] wordsFromLine = input.split(" ");
        for (String word : wordsFromLine) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                if (builder.length() != 0) {
                    builder.append(' ');
                }
                builder.append(word);
            }
        }
    }

    private String[] toStringArray(StringBuilder builder) {
        if (builder.length() != 0) {
            String[] result = builder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } else {
            return new String[0];
        }
    }
}
