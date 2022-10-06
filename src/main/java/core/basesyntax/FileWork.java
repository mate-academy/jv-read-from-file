package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPECIFIED_REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        StringBuilder builder;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        String[] sortedData = new String[]{};
        if (builder.toString().length() == 0) {
            return sortedData;
        }
        String[] splitData = builder.toString().split(SPECIFIED_REGEX);
        int count = 0;
        for (String datum : splitData) {
            if (datum.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                count++;
            }
        }
        sortedData = new String[count];
        int index = 0;
        for (String datum : splitData) {
            if (datum.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                sortedData[index] = datum.toLowerCase();
                index++;
            }
        }
        Arrays.sort(sortedData);
        return sortedData;
    }
}
