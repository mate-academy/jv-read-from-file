package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGEX = "\\W";
    private final StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        final File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                String[] valueWithoutPunctuation = value.toLowerCase().split(REGEX);
                for (String valueFrom : valueWithoutPunctuation) {
                    if (valueFrom.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(valueFrom).append(" ");
                    }
                }
                value = reader.readLine();
            }
            if (stringBuilder.length() == 0) {
                return new String[]{};
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return splitAndSort(stringBuilder);
    }

    private String[] splitAndSort(StringBuilder builder) {
        String[] splittedAndSorted = builder.toString().trim().split(" ");
        Arrays.sort(splittedAndSorted);
        return splittedAndSorted;
    }
}
