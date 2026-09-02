package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            builder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                builder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.length() == 0 ? new String[0] : filterFromNonEmptyFile(builder);
    }

    private String[] filterFromNonEmptyFile(StringBuilder builder) {
        String[] words = builder.toString().split("\\W+");
        builder = new StringBuilder();
        for (String word : words) {
            word = word.toLowerCase();
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                builder.append(word).append(" ");
            }
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        words = builder.toString().split(" ");
        Arrays.sort(words);
        return words;
    }
}
