package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char FILTER_LETTER = 'w';
    private static final String REGEX = "[^A-Za-z0-9 ]";
    private static final String REPLACEMENT_REGEX = "";
    private static final String SPLIT_REGEX = " ";
    private static final String SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(SEPARATOR);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (stringBuilder.length() == 0) {
            return new String[0];
        }

        String[] strings = stringBuilder.toString()
                .toLowerCase()
                .replaceAll(REGEX, REPLACEMENT_REGEX)
                .split(SPLIT_REGEX);

        return filterArray(strings);
    }

    private String[] filterArray(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            if (string.charAt(0) == FILTER_LETTER) {
                stringBuilder.append(string).append(SEPARATOR);
            }
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] filteredStrings = stringBuilder.toString().split(SPLIT_REGEX);
        Arrays.sort(filteredStrings);

        return filteredStrings;
    }
}
