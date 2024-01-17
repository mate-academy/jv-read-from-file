package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SEPARATOR = " ";
    private static final String PUNCTUATION_DELETE_REGEX = "\\W+";
    private static final String START_LETTER = "w";
    private static final int EMPTY_ARRAY_BOUND = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder fileText = new StringBuilder();
        File file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                fileText
                        .append(value)
                        .append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] notSortedArray = wordStartsWithW(fileText.toString());
        Arrays.sort(notSortedArray);
        return notSortedArray;
    }

    private String[] wordStartsWithW(String data) {
        String[] separateWords = data.toLowerCase().split(PUNCTUATION_DELETE_REGEX);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < separateWords.length; i++) {
            if (separateWords[i].startsWith(START_LETTER)) {
                builder
                        .append(separateWords[i])
                        .append(SEPARATOR);
            }
        }

        return builder.isEmpty()
                ? new String[EMPTY_ARRAY_BOUND]
                : builder.toString().split(SEPARATOR);
    }
}
