package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX = "\\W+";
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String WHITESPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName, e);
        }
        String[] words = builder.toString().toLowerCase().split(REGEX);
        StringBuilder wordsWithLetter = new StringBuilder();
        for (String word : words) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                wordsWithLetter.append(word).append(WHITESPACE);
            }
        }
        if (wordsWithLetter.length() == 0) {
            return new String[]{};
        }
        String[] result = wordsWithLetter.toString().split(WHITESPACE);
        Arrays.sort(result);
        return result;
    }
}
