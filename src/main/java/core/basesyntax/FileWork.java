package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SEPARATOR = " ";
    private static final String REGEX = "\\W+";
    private static final int CHARACTER_INDEX = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new String[0];
            }
            while (line != null) {
                stringBuilder.append(line).append(SEPARATOR);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        String[] words = stringBuilder.toString().toLowerCase().split(REGEX);
        int arraySize = 0;
        for (String word : words) {
            if (word.charAt(CHARACTER_INDEX) == 'w') {
                arraySize++;
            }
        }
        String[] resultArray = new String[arraySize];
        int index = 0;
        for (String word : words) {
            if (word.charAt(CHARACTER_INDEX) == 'w') {
                resultArray[index] = word;
                index++;
            }
        }
        Arrays.sort(resultArray);

        return resultArray;
    }
}
