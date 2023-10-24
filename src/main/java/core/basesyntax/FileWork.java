package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String UPPER_CASE_W = "W";
    private static final String LOWER_CASE_W = "w";
    private static final String SPACE = " ";
    private static final String DELIMITER = "\\W+";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        String[] strings = stringBuilder.toString().split(DELIMITER);
        StringBuilder stringBuilder1 = new StringBuilder();
        for (String string : strings) {
            if (string.startsWith(LOWER_CASE_W) || string.startsWith(UPPER_CASE_W)) {
                stringBuilder1.append(string.toLowerCase()).append(SPACE);
            }
        }
        if (stringBuilder1.length() == 0) {
            return new String[0];
        }
        String[] array = stringBuilder1.toString().split(SPACE);
        Arrays.sort(array);
        return array;
    }
}
