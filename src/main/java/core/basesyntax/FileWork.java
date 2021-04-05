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
        String[] resultArray;
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                resultArray = value.toLowerCase().split(DELIMITERS);
                value = bufferedReader.readLine();
                for (String word : resultArray) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        builder.append(word).append(SPACE);
                    }
                }
            }
            if (builder.length() == 0) {
                return new String[]{};
            }
            resultArray = builder.toString().split(SPACE);
            Arrays.sort(resultArray);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read " + fileName, e);
        }
    }
}
