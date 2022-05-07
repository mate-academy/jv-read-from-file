package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String REGEX = "\\W+";
    public static final String SPACE = " ";
    public static final String W_CHARACTER_LOWER_CASE = "w";
    public static final String W_CHARACTER_UPPER_CASE = "W";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String[] arrayOfAllWords = stringBuilder.toString().split(REGEX);
            StringBuilder resultBuilder = new StringBuilder();
            for (String word : arrayOfAllWords) {
                if (word.startsWith(W_CHARACTER_LOWER_CASE)
                        || word.startsWith(W_CHARACTER_UPPER_CASE)) {
                    resultBuilder.append(word.toLowerCase()).append(SPACE);
                }
            }
            if (resultBuilder.length() == 0) {
                return new String[0];
            }
            String[] result = resultBuilder.toString().split(SPACE);

            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }

    }
}
