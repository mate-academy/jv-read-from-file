package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String DELIMITERS = "[^A-Za-z0-9]";
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPACE = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(SPACE);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read " + fileName, e);
        }
        String[] array = builder.toString().toLowerCase().split(DELIMITERS);
        builder.setLength(0);
        for (String word : array) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                builder.append(word).append(SPACE);
            }
        }
        if (builder.length() == 0) {
            return new String[]{};
        }
        array = builder.toString().split(SPACE);
        Arrays.sort(array);
        return array;
    }
}
