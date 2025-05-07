package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private StringBuilder builder = new StringBuilder();
    private int arrayLength = 0;
    private StringBuilder wordStartWithW = new StringBuilder();

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value.toLowerCase()).append(System.lineSeparator());
                value = reader.readLine();
            }
            String [] result = builder.toString().split("\\W+");

            for (String word : result) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    wordStartWithW.append(word).append(" ");
                    arrayLength++;
                }
            }
            if (arrayLength == 0) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        String [] finalResult = wordStartWithW.toString().split(" ");
        Arrays.sort(finalResult);
        return finalResult;
    }
}
