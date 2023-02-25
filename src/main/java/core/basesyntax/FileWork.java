package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String DELIMITER = "\\W+";
    private static final String DELIMITER_FOR_RESULT = " ";
    private static final char LETTER = 'w';

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
                return new String[] {};
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String[] split = stringBuilder.toString().toLowerCase().split(DELIMITER);
            Arrays.sort(split);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                if (split[i].charAt(0) == LETTER) {
                    builder.append(split[i]).append(DELIMITER_FOR_RESULT);
                }
            }
            if (builder.toString().split(DELIMITER_FOR_RESULT).length == 1) {
                return new String[] {};
            } else {
                return builder.toString().split(DELIMITER_FOR_RESULT);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
    }
}
