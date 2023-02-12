package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "\\W+";
    private static final String WHITESPACE_CHARACTER = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] arrayOfData = builder.toString().split(SPECIFIED_CHARACTER);
        for (int i = 0; i < arrayOfData.length; i++) {
            if (arrayOfData[i].toCharArray()[0] == 'W' || arrayOfData[i].toCharArray()[0] == 'w') {
                result.append(arrayOfData[i].toLowerCase()).append(WHITESPACE_CHARACTER);
            }
        }
        if (result.toString().isEmpty()) {
            return new String[0];
        }
        String[] resultingString = result.toString().split(WHITESPACE_CHARACTER);
        Arrays.sort(resultingString);
        return resultingString;
    }
}
