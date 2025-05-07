package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String STRING_TO_SPLIT = "\\W+";
    private static final char START_CHAR = 'w';
    private static final int START_INDEX = 0;
    private String[] allWordsStringArray;
    private String[] sortedArray;

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String currentString = bufferedReader.readLine();
            while (currentString != null) {
                stringBuilder.append(currentString).append(System.lineSeparator());
                currentString = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        allWordsStringArray = stringBuilder.toString().toLowerCase().split(STRING_TO_SPLIT);
        sortedArray = new String[allWordsStringArray.length];
        int indexOfSortedArray = 0;
        try {
            for (String word : allWordsStringArray) {
                if (word.toCharArray()[START_INDEX] == START_CHAR) {
                    sortedArray[indexOfSortedArray] = word;
                    indexOfSortedArray++;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return new String[START_INDEX];
        }
        sortedArray = Arrays.copyOf(sortedArray, indexOfSortedArray);
        Arrays.sort(sortedArray);
        return sortedArray;
    }
}
