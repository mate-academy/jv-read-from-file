package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPLITTER = "@";
    private static final String STRING_FILTER = "\\W+";
    private static final char SHOULD_START_WITH = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        String value;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(SPLITTER);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file: " + file.getName() + e);
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        String[] stringArrayWithoutPunctuation = builder.toString().split(STRING_FILTER);
        builder.delete(0, builder.length());
        for (int i = 0; i < stringArrayWithoutPunctuation.length; i++) {
            if (stringArrayWithoutPunctuation[i].toLowerCase().charAt(0) == SHOULD_START_WITH) {
                builder.append(stringArrayWithoutPunctuation[i].toLowerCase()).append(SPLITTER);
            }
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        String[] sortedArray = builder.toString().split(SPLITTER);
        Arrays.sort(sortedArray);
        return sortedArray;
    }
}
