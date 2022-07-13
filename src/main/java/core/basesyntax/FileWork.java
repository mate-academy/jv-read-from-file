package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String DELIMITER_FOR_SPLIT_METHOD = "\\W+";
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String lowerCaseValue = builder.toString().toLowerCase();
        if (lowerCaseValue == null) {
            return new String[0];
        }
        String[] valueStrings = lowerCaseValue.split(DELIMITER_FOR_SPLIT_METHOD);
        int index = 0;
        for (String value : valueStrings) {
            if (value.startsWith(FIRST_LETTER)) {
                index++;
            }
        }
        String[] endResult = new String[index];
        int index2 = 0;
        for (String value : valueStrings) {
            if (value.startsWith(FIRST_LETTER)) {
                endResult[index2] = value;
                index2++;
            }
        }
        Arrays.sort(endResult);
        return endResult;
    }
}
