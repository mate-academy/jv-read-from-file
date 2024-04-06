package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String[] EMPTY_ARRAY = new String[0];
    private final StringBuilder builder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        int arrayLength = 0;
        int startIndex = 0;
        File myFile = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String value = reader.readLine();
            if (value == null) {
                return EMPTY_ARRAY;
            }
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
            String[] words = builder.toString().replaceAll("\\W", " ").split(" ");
            for (String word : words) {
                String lowerCaseWord = word.toLowerCase();
                if (lowerCaseWord.startsWith(SPECIFIED_CHARACTER)) {
                    arrayLength++;
                }
            }
            String[] resultArray = new String[arrayLength];
            for (String word : words) {
                if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    resultArray[startIndex] = word.toLowerCase();
                    startIndex++;
                }
            }
            Arrays.sort(resultArray, String.CASE_INSENSITIVE_ORDER);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
