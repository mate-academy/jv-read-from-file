package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHARS_TO_REMOVE = "\\W+";
    private static final String WHITESPACE = " ";
    private static final String LOWER_REMOVABLE_CHAR = "w";
    private static final String UPPER_REMOVABLE_CHAR = "W";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Ooops! Can't find file.", e);
        } catch (IOException e) {
            throw new RuntimeException("Ooops! Can't read file.", e);
        }
        return getNeededString(builder);
    }

    private String[] getNeededString(StringBuilder builder) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] inputWords = builder.toString().split(CHARS_TO_REMOVE);
        for (String word : inputWords) {
            if (word.startsWith(LOWER_REMOVABLE_CHAR) || word.startsWith(UPPER_REMOVABLE_CHAR)) {
                stringBuilder.append(word).append(WHITESPACE);
            }
        }
        String stringToChange = stringBuilder.toString().toLowerCase();
        String[] arrayToSort = stringToChange.split(WHITESPACE);
        Arrays.sort(arrayToSort);
        if (stringToChange.length() == 0) {
            return new String[]{};
        }
        return arrayToSort;
    }
}
