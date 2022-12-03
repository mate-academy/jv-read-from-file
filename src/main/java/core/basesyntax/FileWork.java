package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String PATTERN = "\\W+";
    private static final String SEPARATOR = "-";
    private static final char SYMBOL = 'w';
    private static final int INDEX = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String stringLine;
            String[] lineArray;
            while ((stringLine = bufferedReader.readLine()) != null) {
                lineArray = stringLine.toLowerCase().split(PATTERN);
                for (String word : lineArray) {
                    if (word.charAt(INDEX) != SYMBOL) {
                        continue;
                    }
                    stringBuilder.append(word).append(SEPARATOR);
                }
            }

            if (stringBuilder.length() == 0) {
                return new String[0];
            }
            lineArray = stringBuilder.toString().split(SEPARATOR);
            Arrays.sort(lineArray);
            return lineArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
