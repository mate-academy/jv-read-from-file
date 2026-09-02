package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String PUNCTUATION_MARKS = "\\W+";
    private static final String WHITESPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        String[] split = builder.toString().split(PUNCTUATION_MARKS);
        for (int i = 0; i < split.length; i++) {
            if (split[i].toCharArray()[0] == 'W' || split[i].toCharArray()[0] == 'w') {
                result.append(split[i].toLowerCase()).append(WHITESPACE);
            }
        }
        if (result.toString().isEmpty()) {
            return new String[0];
        }
        String[] resultArray = result.toString().split(WHITESPACE);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
