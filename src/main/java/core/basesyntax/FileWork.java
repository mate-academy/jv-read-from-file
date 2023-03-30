package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGEX = "\\W";
    private static final String WHITESPACE = " ";
    private static final String[] EMPTY_ARRAY = new String[]{};

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String item = bufferedReader.readLine();
            if (item == null) {
                return EMPTY_ARRAY;
            }
            while (item != null) {
                String[] data = item.toLowerCase().split(REGEX);
                for (String word : data) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(word).append(WHITESPACE);
                    }
                }
                item = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
        if (stringBuilder.length() == 0) {
            return EMPTY_ARRAY;
        }
        String[] stringOut = stringBuilder.toString().split(WHITESPACE);
        Arrays.sort(stringOut);
        return stringOut;
    }
}
