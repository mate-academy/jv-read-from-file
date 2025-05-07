package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    public static final String REGEX = "\\W+";
    public static final int FIRST_CHAR_POS = 0;

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String readResult = builder.toString();
            if (readResult.isEmpty()) {
                return new String[0];
            }
            String[] unsortedWords = readResult.toLowerCase().split(REGEX);
            int count = 0;
            for (String each : unsortedWords) {
                if (each.charAt(FIRST_CHAR_POS) == 'w') {
                    count++;
                }
            }
            if (count == 0) {
                return new String[0];
            }
            int counter = 0;
            String[] resultArray = new String[count];
            for (int i = 0; i < unsortedWords.length; i++) {
                if (unsortedWords[i].charAt(FIRST_CHAR_POS) == 'w') {
                    resultArray[counter] = unsortedWords[i];
                    counter++;
                }
            }
            Arrays.sort(resultArray, Comparator.naturalOrder());
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("File doesn't exist, or can't read file", e);
        }
    }
}
