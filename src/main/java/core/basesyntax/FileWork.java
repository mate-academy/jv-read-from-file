package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int INDEX = -1;
    private static final String REG_EX = "\\W+";
    private static final String WHITESPACE = " ";
    private static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != INDEX) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return filterFile(stringBuilder);
    }

    private String[] filterFile(StringBuilder fileName) {
        StringBuilder result = new StringBuilder();
        String[] splitFileName = fileName.toString().toLowerCase().split(REG_EX);
        Arrays.sort(splitFileName);

        for (String word : splitFileName) {
            if (word.startsWith(START_LETTER)) {
                result.append(word).append(WHITESPACE);
            }
        }

        return result.length() > 0 ? result.toString().split(WHITESPACE) : new String[0];
    }
}
